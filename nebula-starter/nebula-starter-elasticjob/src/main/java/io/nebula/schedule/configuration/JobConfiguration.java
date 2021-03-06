package io.nebula.schedule.configuration;

import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 徐步龙
 */
@Configuration
@EnableConfigurationProperties(ElasticProperties.class)
public class JobConfiguration {
    @Autowired
    private ElasticProperties elasticProperties;

    @Bean
    public ZookeeperConfiguration zkConfig() {
        String zkServer = elasticProperties.getZkServer();
        String namespace = elasticProperties.getNamespace();
        return new ZookeeperConfiguration(zkServer, namespace);
    }

    @Bean
    public CoordinatorRegistryCenter setUpRegistryCenter(ZookeeperConfiguration zkConfig) {
        CoordinatorRegistryCenter registryCenter = new ZookeeperRegistryCenter(zkConfig);
        registryCenter.init();
        return registryCenter;
    }

}
