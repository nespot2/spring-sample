import com.ewerk.gradle.plugins.tasks.QuerydslCompile

plugins {
    id("org.springframework.boot") version "2.1.6.RELEASE"
    java
    id("com.ewerk.gradle.plugins.querydsl") version "1.0.10"
}

group = "com.nespot2.springsample"
version = "0.0.1"
apply(plugin = "io.spring.dependency-management")


repositories {
    mavenCentral()
}

val querydslSrcDir = "src/main/generated"

querydsl {
    library = "com.querydsl:querydsl-apt"
    jpa = true
    querydslSourcesDir = querydslSrcDir
}

tasks.getByName<QuerydslCompile>("compileQuerydsl") {
    options.annotationProcessorPath = configurations.getByName("querydsl")
}

configurations.getByName("querydsl") {
    extendsFrom(configurations.getByName("compileClasspath"))
}

sourceSets {
    getByName("main").java.srcDirs(listOf("src/main/java", querydslSrcDir))
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-batch")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-security")
    implementation("com.querydsl:querydsl-jpa")
    implementation("org.springframework.boot:spring-boot-devtools")
    implementation("nz.net.ultraq.thymeleaf:thymeleaf-layout-dialect")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    runtimeOnly("org.mariadb.jdbc:mariadb-java-client")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}