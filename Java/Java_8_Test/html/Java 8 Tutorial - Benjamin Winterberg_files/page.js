$(function () {

  $.ajax({
    url: 'http://winterbe.herokuapp.com/social/countAll',
    success: function (social) {
      var pageUrl = $('[data-page-url]').data('pageUrl');
      var pageResult = social[pageUrl];
      if (pageResult.totalCount > 0) {
        $('.share-count-total').text('Shared ' + pageResult.totalCount + ' times');
      }
      $('.share-count-twitter').text(pageResult.twitter.count);
      $('.share-count-facebook').text(pageResult.facebook.count);
      $('.share-count-googleplus').text(pageResult.googlePlus.count);
      $('.share-count-reddit').text(pageResult.reddit.count);
    }
  });

});
