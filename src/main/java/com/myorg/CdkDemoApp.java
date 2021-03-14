package com.myorg;

import software.amazon.awscdk.core.App;

import java.util.Arrays;

public class CdkDemoApp {
    public static void main(final String[] args) {
        App app = new App();

        new CdkDemoStack(app, "CdkDemoStack");

        app.synth();
    }
}
