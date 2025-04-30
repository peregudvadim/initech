package by.peregud.initech.llc.config;

import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@EnableCaching
public class CachingConfig implements CachingConfigurer {
    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();

        List<Cache>caches = List.of(
                new ConcurrentMapCache("application"),
                new ConcurrentMapCache("clients"),
                new ConcurrentMapCache("contracts"),
                new ConcurrentMapCache("departments"),
                new ConcurrentMapCache("employees"),
                new ConcurrentMapCache("invoices"),
                new ConcurrentMapCache("payments"),
                new ConcurrentMapCache("transactions"),
                new ConcurrentMapCache("users")
        );

        cacheManager.setCaches(caches);
        return cacheManager;
    }

    @Bean("customKeyGenerator")
    public KeyGenerator keyGenerator() {
        return new CustomKeyGenerator();
    }

}
