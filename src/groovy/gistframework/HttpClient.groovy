package gistframework;

import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.Method.GET
import static groovyx.net.http.ContentType.JSON
import org.yaml.snakeyaml.Yaml

class HttpRequest {

    public static final InputStream INPUT = new FileInputStream(new File("config.yml"))
    public static final Yaml YAML = new Yaml()
    public static final Object PROPERTIES = YAML.load(INPUT)
    private final static String MYURL = "https://api.github.com"

    //Sends an http request
    private send(method, path, query) {

        def http = new HTTPBuilder(MYURL)

        http.setProxy('localhost', 8080, 'http')
        http.ignoreSSLIssues()

        http.request(method, JSON) {
            uri.path = path
            uri.query = query
            headers."User-agent" = "ActiveMeasure Test"
            headers."Authorization" = PROPERTIES["Authorization"]

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
        return(send(GET, "/gists", [:]))
    }

    public addGist() {

    }
}