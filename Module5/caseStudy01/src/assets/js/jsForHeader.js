$(window).on("scroll", function () {
  scrollFunction();
})

function scrollFunction() {
  if ($("html").scrollTop() > 80) {
    $("#navbarSupportedContent a").css("color", "#8a8a8a");
    $("#navbarSupportedContent a").mouseenter(function () {
      $(this).css("color", "#ffffff");
    });
    $("#navbarSupportedContent a").mouseleave(function () {
      $(this).css("color", "#8a8a8a");
    });
    $("#menu").css("backgroundColor", "#444444");
  } else {
    $("a").css("color", "#0a600a")
    $("#navbarSupportedContent a").mouseenter(function () {
      $(this).css("color", "#63cb63");
    });
    $("#navbarSupportedContent a").mouseleave(function () {
      $(this).css("color", "#0a600a");
    });
    $("#menu").css("backgroundColor", "white");
  }
}
