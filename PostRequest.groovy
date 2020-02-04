import groovy.json.JsonSlurper

def postmanGet = new URL('http://api.ipinfodb.com/v3/ip-city/?key=816662489b3e3be9d7111d964c2b7f9db88d74ec49b6babfc38e08df5c3b619d&ip=192.121.200.6&format=json')
def getConnection = postmanGet.openConnection()
getConnection.requestMethod = 'GET'
getConnection.doOutput = true
//add request header
getConnection.setRequestProperty("Content-Type", "application/json")
int responseCode = getConnection.getResponseCode()
println("Url":postmanGet)
println("ResponseCode":responseCode)
//Reading the input
BufferedReader inst = new BufferedReader(
        new InputStreamReader(getConnection.getInputStream()))
println(inst)
String read
StringBuffer app = new StringBuffer()
while ((read = inst.readLine())!= null){
    app.append(read)
}
inst.close()

println(app.toString())

def parser = new JsonSlurper()
def obj = parser.parseText(app.toString())
println("StatusCode":obj.getAt("statusCode"))
println("StatusMessage" : obj.getAt("statusMessage"))