# Admin Page for telegram-trash-talk bot

## Compiling JS
### For development:
**Start webpack dev server**
```
sbt dev
```
Then you can open application at http://localhost:8080 in browser.
The dev server support hot reload.

### For production:
**Generate built application**
```
sbt build
```
Result will be generated at _build_ directory. It minifies 