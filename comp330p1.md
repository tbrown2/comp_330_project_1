#Roadmap 

Before beginning this assignment I took great measure in trying to decide which language I wanted to use. I settled on Java for this project for multiple reasons. 
	1) I have experience with Java. This reason probably is the least worthy of being noted, but it carries great weight. I figure that later on in the semester I will probably be working the most with Java so why not get some practice in before the semester starts?
	2) It's easy to write unit tests in Java using JUnit. 
	3) Lots of online resources in Java. 
	4) Lots of libraries that make it easy to manipulate strings. 
	5) Doesn't need to be fast, does not need to interface directly to the hardware. 

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

#Classes

##Tweet ---- make a tree? where each node represents a different chunk of the tweet? Or make into a class
  Attributes:
    text -- the actual body of the tweet, cannot exceed 140 characters, this part would be a tree
    date -- can be used to keep track of the first 3200 tweets
    charlength -- the number of characters in the tweet, cannot exceed 140 characters 
    mentions[] -- could just make an array of each mention possessed
    hashtags[] -- could just make an array of each hastag
    urls[] -- could just make an array of each url

##Linkables (superclass)

	Mention (subclass)
	    Attributes
		- int start_location (inherited)
		- int length (inherited)
		- string body(inherited)
	    Methods 
		- GetLocation (inherited)
                - GetLength (inherited)
	        - GetBody (inherited)

	Hashtag (subclass)
            Attributes
		- start_location (inherited)
		- length (inherited)
		- string body(inherited)
	    Methods 
		- GetLocation (inherited)
                - GetLength (inherited)
	        - GetBody (inherited)

	Url (subclass)
	    Attributes
		- start_location (inherited)
		- length  (inherited)
                - string body (inherited)
	    Methods 
		- GetLocation (inherited)
                - GetLength (inherited)
	        - GetBody (inherited)
	