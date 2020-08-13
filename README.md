# DietApp

## Introduction
Android app meant to help you creating a healthy, various and balanced food habits. It starts with creating a user and inserting basic pieces of infromation (age, exercise intensivity, sex etc.). Then the program calculates your supposed calories intake based on Harris-Benedict Equation. Once logged in you will be able to choose your meal and the limit of calories of said meal. The daily calories limit will be based on the Harris-Benedict Equation and will reset after the day. The food suggestions will be randomly chosen using Edamam REST Api(I chose this Api as it contains a lot of nutritient values except for bare minimum like meal,calories) . The user will be able to save the favourite meals.

## Technologies

- RxJava 2 
- Retrofit
- Room Persistance Library
- Dagger 2
- LiveData
- Design pattern - MVVM

## Dependencies

- Edamam REST Api

## Status
App is in early stages of development, having implemented the Authorization module with user creation. Dagger is set up, ready to work on the main module. I am thinking about using Firebase for my user authentication as it currently is done locally with Room. The potential to expand app's funcionality is huge so right now I am working on what is mentioned in Introduction and will probably implement extra features in the future.
