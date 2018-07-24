package gistframework;

import groovyx.net.http.HTTPBuilder
import groovy.json.JsonSlurper
import static groovyx.net.http.Method.GET
import static groovyx.net.http.Method.POST
import static groovyx.net.http.Method.PATCH
import static groovyx.net.http.Method.DELETE
import static groovyx.net.http.ContentType.JSON
import org.yaml.snakeyaml.Yaml

class HttpRequest {

    public static final InputStream INPUT = new FileInputStream(new File("config.yml"))
    public static final Yaml YAML = new Yaml()
    public static final Object PROPERTIES = YAML.load(INPUT)
    private final static String MYURL = "https://api.github.com"

    //Sends an http request
    private send(method, path, query, bodyContent) {

        def http = new HTTPBuilder(MYURL)

        http.setProxy('localhost', 8080, 'http')
        http.ignoreSSLIssues()

        http.request(method, JSON) {
            uri.path = path
            uri.query = query
            headers."User-agent" = "ActiveMeasure Test"
            headers."Authorization" = "token " + PROPERTIES["Authorization"]

            if (method == POST){
                body = bodyContent
            }

            if (method == PATCH){
                body = bodyContent
            }

            //If response is successful do this
            response.success = { resp, json ->
                return [resp, json]
            }

            //If response is unsuccessful do this
            response.failure = { resp, json ->
                return [resp, json]
            }
        }
    }

    public getGists() {
        return(send(GET, "/users/marcohuerta123/gists", [:], [:]))
    }

    public addGist(description, isPublic)  {

        def slurper = new groovy.json.JsonSlurper()
        def fileObject = slurper.parseText('{"helloworld.rb": {"content": "Run `ruby hello_world.rb` to print Hello World"}}')

        return(send(POST, "/gists", [:], [description:description, public: isPublic, files: fileObject]))
    }

    public editGist(id, description) {

        def slurper = new groovy.json.JsonSlurper()
        def fileObject = slurper.parseText('{"helloworld.rb": {"content": "Run `ruby hello_world.rb` to print Hello World Modified"}}')

        def path = "/gists/" + id

        return(send(PATCH, path, [:], [description:description, files: fileObject]))

    }

    public deleteGist(id) {
        def path = "/gists/" + id

        return(send(DELETE, path, [:], [:]))
    }
}