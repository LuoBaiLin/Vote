
	//自定义序号咧单元格内容value是单元格的值,index序号从0开始，row行对象，return给单元格赋值
	function indexFormatter(value,row,index){
		return index+1;
	}
	function operateFormatter(value,row,index){
		return '<a href="Voting.action?subid='+value+'" style="color:blue">参与投票</a>';
	}
  	function add(){
  		alert("add''");
  	}
  	
function myLoadFilter(data, parent){
			var state = $.data(this, 'tree');
			
		    function setData(){
		    	var serno = 1;
		        var todo = [];
		        for(var i=0; i<data.length; i++){
		            todo.push(data[i]);
		        }
		        while(todo.length){
		            var node = todo.shift();
		            if (node.id == undefined){
		            	node.id = '_node_' + (serno++);
		            }
		            if (node.children){
		                node.state = 'closed';
		                node.children1 = node.children;
		                node.children = undefined;
		                todo = todo.concat(node.children1);
		            }
		        }
		        state.tdata = data;
		    }
		    function find(id){
		    	var data = state.tdata;
		    	var cc = [data];
		    	while(cc.length){
		    		var c = cc.shift();
		    		for(var i=0; i<c.length; i++){
		    			var node = c[i];
		    			if (node.id == id){
		    				return node;
		    			} else if (node.children1){
		    				cc.push(node.children1);
		    			}
		    		}
		    	}
		    	return null;
		    }
		    
		    setData();
		    
		    var t = $(this);
		    var opts = t.tree('options');
		    opts.onBeforeExpand = function(node){
	    		var n = find(node.id);
	    		if (n.children && n.children.length){return;}
		    	if (n.children1){
		    		var filter = opts.loadFilter;
		    		opts.loadFilter = function(data){return data;};
		    		t.tree('append',{
		    			parent:node.target,
		    			data:n.children1
		    		});
		    		opts.loadFilter = filter;
		    		n.children = n.children1;
		    	}
		    };
			return data;
		}
		
		$(function(){
			  		$("#addtab").click(function(){
					    var len=$("#ta tr").length;
					    $("#ta").append("<tr><td></td><td><input  name='voteoption'  class='easyui-textbox'  style='width:300px;height:25px'></td></tr>");
			  		});
			  		var test = document.getElementById("addtab");  
			  		var div = document.getElementById("aa");  
			  		test.onclick = function () {  
			  		    boxScroll(div);  
			  		}  ;

			  		function boxScroll(o){  
			  		 o.scrollTop = o.scrollHeight;  
			  		}  
			var pager = $('#dg').datagrid().datagrid('getPager');	
			pager.pagination({
				buttons:[{
					iconCls:'icon-search',
					handler:function(){
						alert('search');
					}
				},{
					iconCls:'icon-add',
					handler:function(){
						alert('add');
					}
				},{
					iconCls:'icon-edit',
					handler:function(){
						alert('edit');
					}
				}]
			});	
		});