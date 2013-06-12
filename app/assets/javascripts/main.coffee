require ["jquery"], ($) ->
  $ ->

    requirejs.onError = (err) ->
      $("#results").html("No jsRoutes found.").addClass "error"

    require ["routes"], () ->
      $("#results").html(if (jsRoutes?) then "Found jsRoutes.").addClass "success"

