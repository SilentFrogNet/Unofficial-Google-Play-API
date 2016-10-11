# Unofficial Google Play API
An Unofficial REST API to search on Google Play Store

## Methods 
 * search(String, String)
 * search(String)
 * searchApp(String)
 * searchMovie(String)
 * searchBook(String)
 * searchMagazine(String)
 * searchMusic(String)
 
## Android Dependencies
The android version needs the [Retrofit library](https://square.github.io/retrofit/) by [Square](http://square.github.io/).

Add the following code into your app gradle file:

    compile 'com.squareup.retrofit2:retrofit:(insert latest version)'


## Python Dependencies
In order to get the code to work, you need to install **BeautifulSoup** package

    sudo pip install BeautifulSoup

To test the python app run the python script:

    python testgpa.py my search string
    
