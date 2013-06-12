# play-hard-jsroutes
This [Play 2.1.x][play] application builds a hard routes file from the reverse javascript routes file using [curl][curl].

# Intro
The reason why I built this was to make it easier to create a hard copy of the routes file. By having an actual routes file versus the dynamic one, the file can be minified and packaged when run through the [r.js optimizer][rjsopt] during a distribution. Thus reducing requests and increasing speed.

# Usage
Clone repository and cd into the directory.

Add execute permissions to the buildroutes file:

    chmod +x buildroutes.sh

To see how it works starting with `play ~run` will show a message - "No jsRoutes found."

[RequireJS][requirejs] in this case is trying to require the `routes.js` file, but it doesn't exist yet, only the dynamically created `dev-routes.js` exists.

Stop the server and start it with `play -Djsr=build ~run`. This will trigger the `buildroutes.sh` script after the Play application has started and should result in showing the message - "Found jsRoutes."

There is a `sleep 3;` count to wait for the file to be written from the curl before play starts the server and can be adjusted.

Modify the `buildroutes.sh` file to suit your needs.

# In a nutshell

Creates a hard routes file from the dynamically generated javascript routes file.

    play -Djsr=build ~run

## License
MIT: <http://jmparsons.mit-license.org> - [@jmparsons](http://twitter.com/jmparsons)

[curl]: http://curl.haxx.se/download.html
[play]: http://www.playframework.org/
[rjsopt]: http://requirejs.org/docs/optimization.html
[requirejs]: http://requirejs.org/