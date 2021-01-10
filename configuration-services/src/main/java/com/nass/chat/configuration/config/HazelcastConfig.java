package com.nass.chat.configuration.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.ManagementCenterConfig;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.spring.cache.HazelcastCacheManager;

@Configuration
public class HazelcastConfig {

	@Autowired
	Environment environment;

	@Bean
	Config config() { // (1)
		Config config = new Config();

		NetworkConfig network = config.getNetworkConfig();
		network.setPort(5700).setPortCount(20);
		network.setPortAutoIncrement(true);
		JoinConfig join = network.getJoin();
		join.getMulticastConfig().setEnabled(false);
		network.getJoin().getTcpIpConfig().setEnabled(true);
		network.setPortAutoIncrement(true);

		String members = environment.getProperty("hazelcast.members", String.class);
		if (!StringUtils.isEmpty(members))
			network.getJoin().getTcpIpConfig().addMember(members);

		ManagementCenterConfig mcc = new ManagementCenterConfig().setUrl("http://127.0.0.1:38080/mancenter")
				.setEnabled(false);
		config.setManagementCenterConfig(mcc);

		return config;
	}

	@Bean
	public HazelcastInstance hazelcastInstance() {
		return Hazelcast.newHazelcastInstance(config()); // (2)
	}

	@Bean
	CacheManager cacheManager() {
		HazelcastCacheManager hcm = new HazelcastCacheManager(hazelcastInstance()); // (3)
		return hcm;
	}
}
