#Roadmap 

Before beginning this assignment I took great measure in trying to decide which language I wanted to use. I settled on Java for this project for multiple reasons. 
- I have experience with Java. This reason probably is the least worthy of being noted, but it carries great weight. I figure that later on in the semester I will probably be working the most with Java so why not get some practice in before the semester starts?
- It's easy to write unit tests in Java using JUnit. 
- Lots of online resources in Java. 
- Lots of libraries that make it easy to manipulate strings. 
- Doesn't need to be fast, does not need to interface directly to the hardware. 

My first step in this assignment isto map out some rules and requirements that are relevant to parsing a string in twitter. This not only covers some relevant/basic information to the scope of this project, but some information that might help if you wanted to build on this project more in the future. 

My second step isto map out the organization of modules for the project, how each module interacts with the other ones, and build relevant classes and methods. 

My third step is to build the unit tests, and modify my code to pass these tests. For this step, I opted out of building tests after the creation of each class/method, because I figured that the project was not so big that it wouldn't be to my disadvantage to take a more intense TDD.

#Requirements

Taken from https://www.hashtags.org/featured/twitter-for-beginners-basic-guidelines-before-you-start/, and https://support.twitter.com/articles/166337

- maximum length of a username is 15 characters
- tweets should be under 140 characters 
= tweets may contain links: URL's and also shortened URL's like bit.ly and tinyurl, this can reduce the length of a link to 20 characters, twitter also has its own URL shortener t.co
- The last 3200 tweets are available to view 
- A mention is @ followed by  a valid username will allow others to access that users profile, the @ and the username will appear in blue hypertext, this is used to call out others on twitter
- If a mention is not followed by a valid username then it will not hyperlink to that users page
- a valid URI will hyperlink in the tweet 
- a tweet can be pinned at the top of your page
- a hashtag is a # immediately followed by a word or phrase, When you click on a hashtag, you'll see other Tweets containing the same keyword or topic.
