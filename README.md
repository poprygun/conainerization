# Containerization Options

## Utility Gems

Explore Open API Spec of the cluster

```bash
kubectl proxy --port 8080

curl localhost:8080/openapi/v2 > swagger.json

docker run -p 80:8080 -e SWAGGER_JSON=/swagger.json -v $(pwd)/swagger.json:/swagger.json swaggerapi/swagger-ui
```
