# Problems & Solutions
## How to add typescript to a vue project
## How to transmit data to subcomponents dynamically?
Example:
We can add key to subComponent in _SuperComponent.vue_:
```
<template>
    <subComponent key='aKey' :data="this.Data"></subComponent>
</template>
<script>
import subComponent from "RelativePathOfSubComponent"
    component: {
        subComponent,
    }
    data() {
        Data: aData(Eg. 11.1, 'hello', false)
        aKey: aData1(Eg. 11, 'bye', true)
    }
    ...
    Data = bData;
    ...
    // We want to transmit this.Data with another value to subComponent now
    aKey = bData1; (note: bData1 != aData1)
</script>
```
When the value of aKey change, the subComponent will be re-rendered. At this moment, this.Data will be transmitted to
subComponent again
