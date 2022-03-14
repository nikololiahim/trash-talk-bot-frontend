# Admin Page for telegram-trash-talk bot
##Required tools
Application requires node with 16 version and last version of sbt.
(Application is incompatible with 17 version of node)


## Compiling JS
### For development:
**Start webpack dev server**
```
sbt dev
```
Then you can open application at http://localhost:8080 in browser.
The dev server support hot reload.

### For testing
Start tests
```
sbt test
```

### For production:
**Generate built application**
```
sbt build
```
Result will be generated at _build_ directory. It minifies 