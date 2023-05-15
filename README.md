# tech-stack-fullstack
Tech Check



Total number of comments that are shorter than 15 characters
Total number of comments that refer to the "Mover" device
Total number of comments that refer to the "Shaker" device
The daily comments are stored in text files under the docs directory within the project. Each line represents a single comment by a customer. All files in the directory get analyzed and the report gets printed to the console.

Prerequisites
Git
JDK 1.8 or later
An IDE of your choice (Eclipse, IntelliJ IDEA etc)

 Concurrency
Our social media pages are becoming more popular! We expect our daily comment files to become huge, resulting in long processing times per file. The current code processes the files sequentially. Change the implementation to process them concurrently using separate threads (ie one thread per file) and then consolidate the results to print the report.

Bear in mind that at any given time, there can be thousands of comment files in the docs folder which might crash the app if we spawn threads uncontrollably.
