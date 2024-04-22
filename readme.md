Rebuild maven project: `mvn clean install`  
Run spring app: `mvn spring-boot:run`

# OPEN API

Open API specification permits the auto-generation of services for my frontend to create HTTP requests.

- URL: [http://127.0.0.1:8088/api/v1/swagger-ui/index.html](http://127.0.0.1:8088/api/v1/swagger-ui/index.html)

1. Click "/api/v1/v3/api-docs"
2. Copy the content to "src/openapi/openapi.json" of your Angular project.

Go to [npmjs.com](https://www.npmjs.com/) search for `ng-openapi-gen` --> run `npm i ng-openapi-gen`
 to create service in package.json create the script :  "api-gen": "ng-openapi-gen --input ./src/openapi/openapi.json --output ./src/app/services"

 that is in the format of the docs in ng-openapi-gen,
 then run 'npm run api-gen'

 next in app.module add :
   imports: [
            ....       
        HttpClientModule,
        ...
    ],
  providers: [
    ...
    HttpClient, 
    ....
  ]   


  # angular-code-input for otp -> 'https://www.npmjs.com/package/angular-code-input'


  # Modules 
  to create a module --> ng g m book --routing
and
  in app-routing -> loadChildren


# Interceptor
In angular service the interceptor add the jwt token to every http request, ricordati di aggiornare i provider. BaseProject_SpringAngular_Auth


# GUARD
 - npm g guard auth -> CanActivate
 - npm instal @auth0/angular-jwt -> is needed to get the exipired state of the token
