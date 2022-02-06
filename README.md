# Admin Page for telegram-trash-talk bot

## Compiling JS
### For development:
```
sbt fastOptJS / webpack
```
_NOTE: This command doesn't work right now due to a bug in some dependencies._

#### For production:
```
sbt fullOptJS / webpack
```

After compiling, the code can be run by
opening `index.html` in your browser.