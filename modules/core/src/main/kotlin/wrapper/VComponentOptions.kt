package wrapper

import external.composition_api.SetupFunction

interface VComponentOptions {
    var name: String?
    var props: VPropDefs?
    var setup: SetupFunction<*>?
}
