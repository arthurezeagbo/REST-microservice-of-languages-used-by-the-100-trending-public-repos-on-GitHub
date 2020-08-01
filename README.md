# REST-microservice-of-languages-used-by-the-100-trending-public-repos-on-GitHub
For every language, it calculates the number of repos using this language and the list of repos using the language

This repository has 3 branches and each branch is is a Spring Boot micro service project except the master branch.

For you to be able to run applications, your are supposed to have a Java runtime in your environment and follow below steps:
1. Download and run repo-data-service branch.
2. Then dowload and run repo-info-service branch.
3. You do not need to download or run master branch.

Once the two micro services are up and running, copy and paste http://localhost:8082/api/v1/info/getlanguages
on your browser and run. If everthing is properly done, your brower will display the list of languages of 100 trending
repositories on Github, total count of repositories for that language, and the list of repositories.

I will be implementing Service Discovery in no distance time.


