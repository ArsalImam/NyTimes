# Android - NewYorkTimes Integration
## Introduction
This is a sample project which demostrates the integration of APIs from the NewYorkTime server,
We'll be using the most viewed section of this API. Note: you need to signup for an API key
at: https://developer.nytimes.com/get-started, then replace the ‘sample-key’ below with
the API key assigned to your account.
http://api.nytimes.com/svc/mostpopular/v2/viewed/{period}.json?api-key=sample-key
To test this API, you can change the period section of the path (available period values are 1,
7 and 30, which represents how far back, in days, the API returns results for).
https://api.nytimes.com/svc/mostpopular/v2/viewed/7.json?api-key=sample-key

## Reports

 1. Android Lint: https://github.com/ArsalImam/NyTimes/tree/master/reports/lint
 2. SonarQube Analysis: https://sonarcloud.io/dashboard?id=ArsalImam_NyTimes
 3. Test results: https://github.com/ArsalImam/NyTimes/tree/master/reports/test-results
 

## Details about the Recipe
#### Basic Architecture
This project is build using the best practises mentioned on android developer guidelines, following are the main components which used by this library,

 - MVVM (as a primary arch)
 - Data Binding v2
 - Design Patterns (Service Locator, Repository, Factory, Singleton etc)

#### Common Libraries

 - Retrofit (for network related operations)
 - Picasso (for image loading/caching)

## Author
ArsalImam
