plugins {
    java
    `java-library`
    id("org.springframework.boot") version "2.3.5.RELEASE"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
}

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
    }

    ext {
    }
}

configure(subprojects.filter { it.path.contains("debezium") }) {
    apply(plugin = "java")
    apply(plugin = "java-library") // dependency api 사용
    apply(plugin = "org.springframework.boot")
    apply(plugin = "io.spring.dependency-management")

    tasks.bootJar { enabled = true }
    tasks.jar { enabled = false }

    java {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    dependencies {
        compileOnly("org.projectlombok:lombok:1.18.16")
        testCompileOnly("org.projectlombok:lombok:1.18.16")
        annotationProcessor("org.projectlombok:lombok:1.18.16")
        testAnnotationProcessor("org.projectlombok:lombok:1.18.16")

        implementation("org.springframework.boot:spring-boot-starter")

        annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
        testAnnotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

        testImplementation("org.springframework.boot:spring-boot-starter-test")
    }
}
