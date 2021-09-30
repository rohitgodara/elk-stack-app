# elk-stack-app

1. download and unzip elasticsearch.zip file 
2. download and unzip logstash.zip file
3. download and unzip kibana.zip file
4. Now go to elastic-search/bin folder and run elasticsearch.bat file to start elastic-search
5. Now go to kibana/config folder and uncomment or add below line in kibana.conf file.
	elasticsearch.hosts: ["http://localhost:9200"]
6. and run kibana.bat file to start kibana.

7. Logstash configuration and startup steps:
1. now open logstash folder and go to config folder.
2. now open logstash-sample.conf file and add below configuration data into that.
===========================================================================================
# Sample Logstash configuration for creating a simple
# Beats -> Logstash -> Elasticsearch pipeline.

input {
  file {
   path => "C:/Users/rohit.godara/Documents/workspace-spring-tool-suite-4-4.10.0.RELEASE/SpringSecurityWithJWT/application.log"
   start_position => "beginning"
  }
  
  beats {
    port => 5044
  }
}

output {

  stdout{
    codec => rubydebug
  }
  elasticsearch {
    hosts => ["http://localhost:9200"]
    index => "elk-application-%{+YYYY.MM.dd}"
    #user => "elastic"
    #password => "changeme"
  }
}
===========================================================================================

3. To start, use below command 
   logstash -f pathToConfigFile\logstash-sample.conf