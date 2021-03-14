package com.myorg;

import software.amazon.awscdk.core.Construct;
import software.amazon.awscdk.core.Stack;
import software.amazon.awscdk.core.StackProps;
import software.amazon.awscdk.services.apigateway.LambdaRestApi;
import software.amazon.awscdk.services.lambda.Code;
import software.amazon.awscdk.services.lambda.Function;
import software.amazon.awscdk.services.lambda.Runtime;

public class CdkDemoStack extends Stack {
    public CdkDemoStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public CdkDemoStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        // The code that defines your stack goes here
        final Function hello = Function.Builder.create(this, "HelloHandler")
                .runtime(Runtime.NODEJS_10_X)    // execution environment
                .code(Code.fromAsset("lambda"))  // code loaded from the "lambda" directory
                .handler("hello.handler")        // file is "hello", function is "handler"
                .build();
        
        // Defines an API Gateway REST API resource backed by our "hello" function
        LambdaRestApi.Builder.create(this, "Endpoint")
            .handler(hello)
            .build();
    }
}
