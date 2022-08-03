$(window).on("scroll", function () {
  scrollFunction();
})

function scrollFunction() {
  if ($("html").scrollTop() > 80) {
    $("#navbarSupportedContent a").css("color", "rgb(255,255,255)");
    // $("#navbarSupportedContent a").mouseenter(function () {
    //   $(this).css("color", "#ffffff");
    // });
    // $("#navbarSupportedContent a").mouseleave(function () {
    //   $(this).css("color", "#ffffff");
    // });
    $("#menu").css("backgroundColor", "rgba(0,0,0,0.90)");
  } else {
    $("a").css("color", "rgb(255,255,255)")
    // $("#navbarSupportedContent a").mouseenter(function () {
    //   $(this).css("color", "#ffffff");
    // });
    // $("#navbarSupportedContent a").mouseleave(function () {
    //   $(this).css("color", "#000000");
    // });
    $("#menu").css("backgroundColor", "rgba(0,0,0,0)");
  }
}
