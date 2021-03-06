package wjc.spring.cloud.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IPing;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.PingUrl;
import com.netflix.loadbalancer.Server;
import com.netflix.loadbalancer.ServerList;
import com.netflix.loadbalancer.ServerListSubsetFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import wjc.spring.cloud.consumer.config.RibbonClientDefaultConfigurationTestsConfig;

/**
 * @author: wangjunchao(王俊超)
 * @time: 2018-12-27 14:26
 **/
public class DefaultRibbonConfiguration {
    private final static Logger logger = LoggerFactory.getLogger(DefaultRibbonConfiguration.class);

    @Bean
    public IRule ribbonRule() {
        return new BestAvailableRule();
    }

    @Bean
    public IPing ribbonPing() {
        return new PingUrl();
    }

    @Bean
    public ServerList<Server> ribbonServerList(IClientConfig config) {
        return new RibbonClientDefaultConfigurationTestsConfig.BazServiceList(config);
    }

    @Bean
    public ServerListSubsetFilter serverListFilter() {
        return new ServerListSubsetFilter();
    }

}
