$(".add-answer-btn").click(addAnswer);

function addAnswer(e) {
	e.preventDefault();
	console.log('add answer');
	
	var url = $(".answer-write").attr("action");
	console.log("url " + url);
	
	var queryString = $(".answer-write").serialize();
	console.log("queryString : " + queryString);
	
	$.ajax({
		type: 'post',
		url: url,
		data: queryString,
		success: function(result) {
			console.log(result);
			
			var template = $("#answerTemplate").html();
			var templateResult = template.format(result.writer.userId, result.formattedCreateDate, result.contents, result.question.id, result.id);
			$(".qna-comment-slipp-articles").append(templateResult);
		},
		error: function() {
			console.log('error');
		}
	});
}

String.prototype.format = function() {
  var args = arguments;
  return this.replace(/{(\d+)}/g, function(match, number) {
    return typeof args[number] != 'undefined'
        ? args[number]
        : match
        ;
  });
};