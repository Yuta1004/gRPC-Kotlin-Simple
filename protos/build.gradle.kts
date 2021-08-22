plugins {
    "java-library"
}

// stubによって使用されるが，その際にprotos/src/main/protoを参照するようにする
java {
    sourceSets.getByName("main").resources.srcDir("src/main/proto")
}
