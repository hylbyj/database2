database2
=========

This is a course project for Advanced Database. Users can find relative information when they searching for people, sports league or sports team. E.g. if you type "Bill Gates", it will give you a info box contains various kinds information of Gates, such as birthday, siblings, companies, etc. When you type a question like "Who created Google?", you will get answers. Using Freebase API""

Created by 
Ariana Giorgi and Yelin Hong

To run the program, there are 3 different implementation methods you may use:
1. run.sh -key <Freebase API key> -q <query> -t <(infobox)|(question)>
2. run.sh -key <Freebase API key> -f <files of queries> -t <(infobox)|(question)> where <file of queries> is a text file of one query per line
3. run.sh -key <Freebase API key>
This method allows you to submit queries interactively.
Example:
run.sh -key AIzaSyCIQ8gDGEMgxJpSsGK6BwkfLZXtN4MTf4E -q “Bill Gates” -t infobox OR
run.sh -key AIzaSyCIQ8gDGEMgxJpSsGK6BwkfLZXtN4MTf4E -q “Who created Google?” -t question
Freebase API Key: AIzaSyCIQ8gDGEMgxJpSsGK6BwkfLZXtN4MTf4E Requests per second per user: standard maximum 10 per second
