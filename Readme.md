### 教程
引入包依赖
```xml
        <dependency>
            <groupId>com.cason</groupId>
            <artifactId>shoplazza-sdk</artifactId>
            <version>2.1.4-SNAPSHOT</version>
        </dependency>
```

指定引用仓库
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