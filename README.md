# kotlin-vue

Kotlin wrapper for [VueJs](https://vuejs.org/).

The project uses [Vue Composition API](https://vue-composition-api-rfc.netlify.com/) Vue2 plugin

#### Compiles and reloads for development

```shell script
./gradlew example:browserRun --continuous
```

Served on `http://localhost:8083`

#### Testing

```shell script
./gradlew test
```

### Useful links

[KotlinLang](https://kotlinlang.org/docs/reference/)

[Kotlin VueJs Slack](https://kotlinlang.slack.com/messages/C8CQT4F47)

[VueJs](https://vuejs.org/)

[Vue Composition API](https://vue-composition-api-rfc.netlify.com/)

[Vue RFCs](https://github.com/vuejs/rfcs/tree/master/active-rfcs)

[Vuex](https://vuex.vuejs.org/)


### Background

The plan is to keep up with the RFC through to Vue3 release, at which point the API will need to change a bit, but should also
stabilize shortly there after.

The hope is to have all Vue3 features available.  A [Vuex](https://vuex.vuejs.org/) wrapper is probable, but not knowing
what the future API looks like I'm not focused on it at this point.

There are no current plans to implement a vue2 component api since working with a proxied `this` was outside of my current 
kotlin skill set.

The current state of this project is POC so the API can and will change without notice.  There is no polish to anything 
nor attempt to do so at this point.  The example app will hopefully have working examples of most if not all the features 
available as this develops.

Contributions in the form of playing with it, bug reports, missing features, pull requests and code reviews are welcome 
(I wrote this to learn kotlin and support two excellent products).

I've also never hosted/managed an open source project like this so if my zippers down, be a bro and let me know.