package com.dddsample.rds.pact;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import com.dddsample.ec2.Application;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/* run with: `mvn -Dtest=VerifyPactsTest clean test' */
@RunWith(PactRunner.class)
@Provider("EC2")
@PactFolder("pact-from-consumer/")
//@PactBroker(host = "localhost", port = "8002")
public class VerifyPactsTest {
    private static ConfigurableApplicationContext application;

    @TestTarget
    public final Target target = new HttpTarget(9001);

    @BeforeClass
    public static void startSpring(){
        application = SpringApplication.run(Application.class);
    }

    @State("default")
    public void toDefaultState() {
        System.out.println("Now service in default state");
    }

    @AfterClass
    public static void kill(){
        application.stop();
    }
}
