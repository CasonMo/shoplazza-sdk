# Shoplazza SDK

Java SDK for Shoplazza REST APIs

notice : This project is based on ChannelApe/shopify-sdk
https://github.com/ChannelApe/shopify-sdk
## Quickstart
Creating SDK with store subdomain and access token, then making a sample call:

```java
  final ShoplazzaSdk shoplazzaSdk = ShoplazzaSdk.newBuilder()
        .withSubdomain(SUB_DOMAIN)
        .withAccessToken(ACCESS_TOKEN)
        .withApiVersion(VERSION)
        .withReadTimeout(120, TimeUnit.SECONDS)
        .withConnectionTimeout(120, TimeUnit.SECONDS)
        .build();
final ShoplazzaShopRoot shop = shoplazzaSdk.getShop();
```
For private apps, `accessToken` should be the private app's Admin API password.


## Building from source

	1. Install Maven
	2. Install JDK 8
	3. Clone the repository.
	3. Navigate to repository directory and run `mvn install`



## from maven repository

```xml
        <dependency>
            <groupId>com.cason</groupId>
            <artifactId>shoplazza-sdk</artifactId>
            <version>2.1.4-SNAPSHOT</version>
        </dependency>
```

```xml

    <repositories>
        <repository>
            <id>mvn-repo</id>
            <url>https://raw.github.com/CasonMo/mvn-repo/master</url>
            <snapshots>
                <enabled>true</enabled>
                <updatePolicy>always</updatePolicy>
            </snapshots>
        </repository>
    </repositories>
```