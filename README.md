# 1ForgeJava

There are two test cases in the current framework
- ValidateMarketStatus: if it's passed => the market is open
- QuotesToCSV: get the quotes of the first 10 pairs, parse the JSON and store the values into sample.csv file 
(created in the root folder of the project)

You have to add your API_KEY as value in the config.properties file.

In order to run the entire test suite, only the execution of the testng.xml file is required.
