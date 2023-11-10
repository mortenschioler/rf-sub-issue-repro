##  Attempt at recreating Re-frame subscription lifecycle issue

## Context

This code was suppose to reproduce a "bug" of sorts in re-frame discussed here: https://github.com/day8/re-frame/issues/797

### Results

It was found that the assertion that in-line subscriptions in 
form-1 components in Reagent are problematic was _false_. 

The analysis was based the finding on an observation that Reagent
does not capture and update subscriptions upon re-render -- it seems
that it actually does.

In my own code (confidential because it's for work) I somehow, and
I still do not understand how, saw this behaviour and looked into 
Reagent, unfortunately reaching the wrong conclusions both on reading
the code (which is quite difficult) and seeing the behavior. 


### Method

Start the app with `clj -X:fig`. Open the console to see when re-renders happen.

This SHOULD HAVE caused stale components according to my statements, but doesn't:

Change the current-id to 1 by pressing the button labeled "Switch to 1". Note that
the view now correctly updates both the ID it is displaying and the corresponding data.


### Conclusion

I was wrong and the issues can be closed. I will make sure to correct myself to avoid
spreading confusion.
