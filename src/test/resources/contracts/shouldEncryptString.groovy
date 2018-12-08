import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return encrypted string"
    request {
        urlPath ("/work") {
            queryParameters {
                parameter "cmd": "helloworld"
            }
        }
        method GET()
    }
    response {
        status 200
        body("dhelloworl")
    }
}