# Moody-Music-App

<h2>Value Proposition</h2>

<ul>
  <li>Moody Music is a music research tool that provides information about music available to stream on Spotify.</li>
  <li>Users can identify popular songs and artists from specific time periods dating back to 1921 and provide recommendations against users' current weather conditions.</li>
  <li>Our competition is online music store fronts, such as the ITUNES music store front.</li>
  <li>Moody Music combines basic information of over 150,000 tracks and unique track traits such as danceability, energy and more to provide recommendations to users.</li>
</ul>  

<h2>Data Sources</h2>

<ul>
  <li>https://www.kaggle.com/yamaerenay/spotify-dataset-19212020-160k-tracks
</li>
  <li>https://openweathermap.org/api</li>
</ul>  

<h2>Features</h2>


<ul>
  <li>User CRUD(create, read, update, and delete)</li>
  <li>Song CRUD</li>
  <li>Favorited songs by user (CRUD)</li>
  <li>Top 100 songs of all time</li>
  <li>Top 100 songs of a specific year</li>
  <li>Top artists of a specific year</li>
  <li>Daily recommend songs based on weather</li>
  <li>User CRUD(create, read, update, and delete)</li>
  <li>Top 100 songs of all time</li>
</ul>  

<h2>Setup</h2>

<ul>
  <li>Install Java JDK (SE JDK): http://www.oracle.com/technetwork/java/javase/downloads/index.html
</li>
  <li>Instead of Eclipse installer, I installed “Eclipse IDE for Enterprise Java Developers”: https://www.eclipse.org/downloads/eclipse-packages/
(then copied to Applications)
</li>
  <li>Download Apache Tomcat 9.X (I have 9.0): http://tomcat.apache.org</li>
  <li>Instructions to create new project, configure Eclipse+Tomcat, and run Tomcat (skip the "Web Tools Platform" step): https://www.mulesoft.com/tcat/tomcat-eclipse</li>
</ul>  


<h2>Create a New Project</h2>

<ul>
  <li>Instructions to create new project, configure Eclipse+Tomcat, and run Tomcat (skip the "Web Tools Platform" step): https://www.mulesoft.com/tcat/tomcat-eclipse</li>
  <li>New "Dynamic Web Project"</li>
  <li>"New Runtime…" > Apache Tomcat v9.0</li>
  <li>Specify installation directory (e.g. /Users/anson/Documents/apache-tomcat-9.0.21)</li>
  <li>Specify "Create a new local server" checkbox (default)</li>
</ul>

<h2>Connector/J</h2>

<ul>
  <li>Download Connector/J and add jar to your buildpath: http://dev.mysql.com/downloads/connector/j/</li>
  <li>Right click project > Build Path > Configure Build Path…</li>
  <li>Libraries > Classpath > Add External JARS…</li>
  <li>Browse to path (e.g. /Users/anson/Documents/mysql-connector-java-8.0.16/mysql-connector-java-8.0.16-bin.jar)</li>
</ul>

<h2>JSTL IMPL and SPEC jars</h2>

<ul>
  <li>Download JSTL IMPL and SPEC jars: (taglibs-standard-impl-1.2.5.jar, taglibs-standard-spec-1.2.5.jar), http://tomcat.apache.org/download-taglibs.cgi</li>
  <li>Copy the JSTL jars to the directory "MoodyMusicApp/WebContent/WEB-INF/lib".</li>
  <li>Also copy the Connector/J jar to this path.</li>
  <li>Specify installation directory (e.g. /Users/anson/Documents/apache-tomcat-9.0.21)</li>
  <li>Refresh</li>
</ul>

<h2>Running - JDBC (data access demo)</h2>

<ul>
  <li>Make sure ConnectionManager.java is created.</li>
  <li>Make sure MySQL is running.</li>
  <li>Create empty tables, e.g.</li>
  <li>Right click Inserter.java: Run As > Java Application.</li>
  <li>View "Console" output.</li>
  <li>Verify data in Workbench.</li>
</ul>

<h2>Running - JSP (web application):</h2>

<ul>
  <li>Insert data (from JDBC or Workbench).</li>
  <li>Right click project: Run As > Run on Server. Start the Tomcat server.</li>
  <li>In a browser, go to: http://localhost:8080/MoodyMusicApp</li>
  <li>View "Console" output.</li>
  <li>To stop: right click server: Stop.</li>
</ul>
