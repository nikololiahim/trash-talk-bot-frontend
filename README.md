# Admin Page for telegram-trash-talk bot

## Compiling JS
### For development:
Install JS dependencies:
```
npm install
```

Compile Scala to JS:
```
sbt fastLinkJS
```

Run `snowpack` dev server:
```
npx snowpack dev
```

### For production:
```
sbt fullLinkJS 
```
