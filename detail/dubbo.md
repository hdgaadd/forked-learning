# source

- https://github.com/apache/dubbo

# structure

```
- dubbo-build-tools
- dubbo-cluster
- dubbo-common
- dubbo-compatible
- dubbo-config
- dubbo-configcenter
- dubbo-container
- dubbo-demo
- dubbo-dependencies
- dubbo-dependencies-b
- dubbo-distribution
- dubbo-filter
- dubbo-metadata
- dubbo-metrics
- dubbo-monitor
- dubbo-native
- dubbo-native-plugin
- dubbo-plugin
- dubbo-registry
- dubbo-remoting
- dubbo-rpc
- dubbo-serialization
- dubbo-spring-boot
- dubbo-test
```



# dubbo-rpc

## dubbo-rpc-dubbo

# dubbo-compatible

> [kəmˈpætəbl兼容的

- 大部分使用@Deprecated修饰



# dubbo-registry

## dubbo-registry-multicast

> [ˈmʌltikɑːst]多路广播

# dubbo-container

- Dubbo的容器启动，实际上是启动Spring的容器

  ```
  context = new ClassPathXmlApplicationContext(configPath.split("[,\\s]+"), false);
  ```

