#! /bin/bash
osascript -e 'tell app "Terminal"
    do script "cd Desktop/SeleniumGrid/ && 
    java -jar selenium-server-standalone.jar -role hub -hubConfig hub.json"
end tell'
osascript -e 'tell app "Terminal"
    do script "cd Desktop/SeleniumGrid/ && 
    java -jar -Dwebdriver.gecko.driver=/usr/local/bin/geckodriver -Dwebdriver.chrome.driver=/usr/local/bin/chromedriver selenium-server-standalone.jar -role node -nodeConfig node.json"
end tell'