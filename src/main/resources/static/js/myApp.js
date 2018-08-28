var app= angular.module('App', ['ui.router','ds.clock','ngCookies','chart.js','angularjs-datetime-picker']);
app.filter('startFrom', function() {
    return function(input, start) {
    	if (!input || !input.length) { return; }
        start = +start; //parse to int
        return input.slice(start);
    }
})
.directive('fileModel', function ($parse) {
    return {
       restrict: 'A',
       link: function(scope, element, attrs) {
          var model = $parse(attrs.fileModel);
          var modelSetter = model.assign;
          
          element.bind('change', function(){
             scope.$apply(function(){
                modelSetter(scope, element[0].files[0]);
             });
          });
       }
    };
})

.factory('SharedData', function($http){
	
	var obj = {
			changeProfil : function(profil){
				
			},
			etatGeneral: "true"
			,
			c:0,
		    getEtudiants : function(){
    		return $http({
		    			method: 'GET',
		    	      url: '/etudiants'
		    	   });
		    },
		    getEnseignants : function(){
	    	return 	$http({
					method: 'GET',
			      url: '/enseignants'
			   });
			   
		    },
	  		getClasses : function(){
	  		return	$http({
	  				method: 'GET',
	  		      url: '/classes'
	  		   });
	  		},
	  		uploadImage : function(file){
	  			var url = "/uploadfile"; 
	  	        var data = new FormData();
	  	        data.append('uploadfile', file);
	  	        var config = {
	  	     	   	transformRequest: angular.identity,
	  	     	   	transformResponse: angular.identity,
	  	 	   		headers : {
	  	 	   			'Content-Type': undefined
	  	 	   	    }
	  	        }
	  	        
	  	        return $http.post(url, data, config);
	  		},
	  		updateUnkownPhoto : function(sexe){
	  			if(sexe =="femelle")
	  			return {urlPath : "http://localhost:8080/files/unkown2.png"};
	  			else 
	  				return {urlPath : "http://localhost:8080/files/unkown.png"};	
	  			
	  		},
	  		sexes : ["male", "femelle"],
	  		test:'hi'
	  		
		    }
	return obj;
})
.config(function($stateProvider,$urlRouterProvider)
	{
		$stateProvider
		.state('etudiants',{
				url : '/etudiands',
				templateUrl : 'views/etudiants.html',
				controller : 'EtudiantsController as etudiantsCtrl'})
		.state('classes',{
				url : '/classes',
				templateUrl : 'views/classes.html',
				controller : 'ClassesController as classesCtrl'})
		.state('fichiers',{
				url : '/fichiers',
				templateUrl : 'views/fichiers.html',
				controller : 'FichiersController as fichiersCtrl'})
		.state('profil',{
				url : '/profil',
				templateUrl : 'views/profil.html',
				controller : 'ProfilController as profilCtrl'})
		.state('enseignants',{
				url : '/enseignants',
				templateUrl : 'views/enseignants.html',
				controller : 'EnseignantsController as enseignantsCtrl'})
		.state('gestioncours',{
				url : '/gestioncours',
				templateUrl : 'views/gestioncours.html',
				controller : 'GestioncoursController as gestioncoursCtrl'})
		.state('contacts',{
				url : '/contacts',
				templateUrl : 'views/contacts.html',
				controller : 'ContactsController as contactsCtrl'})
		.state('cours',{
				url : '/cours',
				templateUrl : 'views/cours.html',
				controller : 'CoursController as coursCtrl'})
		.state('utilisateur',{
				url : '/utilisateur',
				templateUrl : 'utilisateur.html',
				controller : 'UtilisateurController as utilisateurCtrl'})
		.state('login',{
			url : '/login',
			templateUrl : 'views/login.html',
			controller : 'loginCtrl'})
		.state('loginenseignant',{
			url : '/loginenseignant',
			templateUrl : 'views/loginEnseignant.html',
			controller : 'loginenseignantCtrl'})
		.state('loginetudiant',{
			url : '/loginetudiant',
			templateUrl : 'views/loginEtudiant.html',
			controller : 'loginetudiantCtrl'})
		.state('enseignantProfil',{
			url : '/enseignantProfil',
			templateUrl : 'views/enseignantProfil.html',
			controller : 'enseignantProfilCtrl'})
		.state('etudiantProfil',{
			url : '/etudiantProfil',
			templateUrl : 'views/etudiantProfil.html',
			controller : 'etudiantProfilController as etudiantProfilCtrl'})
		.state('classesEnseignant',{
			url : '/classesEnseignant',
			templateUrl : 'views/classesEnseignant.html',
			controller : 'classesEnseignantCtrl as classesEnseignantCtrl'})
		.state('coursEnseignant',{
			url : '/coursEnseignant',
			templateUrl : 'views/coursEnseignant.html',
			controller : 'coursEnseignantCtrl as coursEnseignantCtrl'})
		.state('examenEnseignant',{
				url : '/examenEnseignant',
				templateUrl : 'views/examenEnseignant.html',
				controller : 'examenEnseignantController as examenEnseignantCtrl'})
		.state('classeEtudiant',{
				url : '/classeEtudiant',
				templateUrl : 'views/classeEtudiant.html',
				controller : 'classeEtudiantController as classeEtudiantCtrl'})
	    .state('saisiequiz',{
				url : '/quiz',
				templateUrl : 'views/saisieQuiz.html',
				controller : 'saisieQuizController as quizCtrl'})
		.state('listeCoursEtudiant',{
				url : '/listeCoursEtudiant',
				templateUrl : 'views/listeCoursEtudiant.html',
				controller : 'listeCoursEtudiantController as listeCoursEtudiantCtrl'})
		.state("fenetrefichier",{
                url:"/fichier/:urlpath",
                templateUrl:"views/fichier.html",
                 controller:"fichierController"})
    	.state('passerQuiz',{
			url : '/passerQuiz',
			templateUrl : 'views/passerQuiz.html',
			controller : 'passerQuizController as passerQuizCtrl'})
		.state('contenuQuiz',{
			url : '/contenuQuiz',
			templateUrl : 'views/contenuQuiz.html',
			controller : 'contenuQuizController as contenuQuizCtrl'})
		.state('listeExamens',{
			url : '/listeExamens',
			templateUrl : 'views/listeExamens.html',
			controller : 'listeExamensController as listeExamensCtrl'})
		.state('passerExamen',{
			url : '/passerExamen',
			templateUrl : 'views/passerExamen.html',
			controller : 'passerExamenController as passerExamenCtrl'})
		.state('lesNotifications',{
			url : '/lesNotifications',
			templateUrl : 'views/lesNotifications.html',
			controller : 'lesNotificationsController as lesNotificationsExamenCtrl'})
		.state('notifs',{
			url : '/notifs',
			templateUrl : 'views/notifs.html',
			controller : 'notifsController as notifsCtrl'})
		.state('contacterResponsables',{
			url : '/contacterResponsables',
			templateUrl : 'views/contacterResponsables.html',
			controller : 'contacterResponsablesController as contacterResponsablesCtrl'})
		.state('confirmer',{
			url : '/confirmer',
			templateUrl : 'views/confirmerEtudiant.html',
			controller : 'confirmerController as confirmerCtrl'})
		.state('acceuil',{
			url : '/acceuil',
			templateUrl : 'views/acceuil.html',
			controller : 'acceuilController as acceuilCtrl'})
		.state('public',{
			
			controller : 'PublicController as publicCtrl'})
		.state('registerController',{
			
			controller : 'registerCtrl'})
		.state('retourenseignantController',{
			
			controller : 'retourenseignantController'})
		.state('retouretudiantController',{
			
			controller : 'retouretudiantController'})
		.state('adminMessages',{
			url : '/messagesPubliques',
			templateUrl : 'views/messagesPubliques.html',
			controller : 'adminMessagesController'})
		.state('poste',{
				url : '/poste',
				templateUrl : 'views/poste.html',
				controller : 'PosteController as posteCtrl'})
		.state('statistiques',{
				url : '/statistiques',
				templateUrl : 'views/statistiques.html',
				controller : 'StatistiquesController as statistiquesCtrl'})
		.state('blog',{
				url : '/blog',
				templateUrl : 'views/blog.html',
				controller : 'BlogController as blogCtrl'})
		.state('index',{
				url : '/index',
				controller : 'IndexController as indexCtrl'})
		.state('statAdmin',{
				url : '/statadmin',
				templateUrl : 'views/statadmin.html',
				controller : 'StatAdminController as statAdminCtrl'})
		.state('formsAdmin',{
				url : '/formsadmin',
				templateUrl : 'views/formsadmin.html',
				controller : 'FormsAdminController as formsAdminCtrl'})	
			;
	
		//$urlRouterProvider.otherwise('/acceuil');
	
	})
.controller('FormsAdminController',function($http,$state,SharedData){
	var formsAdminCtrl = this;
	formsAdminCtrl.classes = {};
	formsAdminCtrl.sexes = SharedData.sexes;
	formsAdminCtrl.nouveauEnseignant = {photo :{urlPath:"http://localhost:8080/files/unkown.png"},classesId : [],sexe:"male"};
	formsAdminCtrl.nouveauEtudiant = {photo :{urlPath:"http://localhost:8080/files/unkown.png"}};
	 
	formsAdminCtrl.updatePhoto = function(nb){
		 if(nb == 1){
			 formsAdminCtrl.nouveauEnseignant.photo = SharedData.updateUnkownPhoto(formsAdminCtrl.nouveauEnseignant.sexe);
		 }
		 if(nb == 2){
			 formsAdminCtrl.nouveauEtudiant.photo = SharedData.updateUnkownPhoto(formsAdminCtrl.nouveauEtudiant.sexe);
		 }
			 
		}
	 SharedData.getClasses().then(function (success){
		 formsAdminCtrl.classes = success.data;
		   },function (error){
			   console.log(error);
		   });
	 formsAdminCtrl.annulerEnseignant = function(){
		 formsAdminCtrl.nouveauEnseignant = {photo :{urlPath:"http://localhost:8080/files/unkown.png"},classesId : []};
	 }
	 formsAdminCtrl.annulerEtudiant = function(){
		 formsAdminCtrl.nouveauEtudiant = {photo :{urlPath:"http://localhost:8080/files/unkown.png"}};
	 }
	 formsAdminCtrl.ajouterEnseignant = function(){
		 formsAdminCtrl.nouveauEnseignant.dateDeCreation = new Date();
			$http({
				method: 'POST',
		      url: '/enseignants',
		      dataType: 'json',
		      data    : formsAdminCtrl.nouveauEnseignant,
		      headers : {
			        'Content-Type' : 'application/json'
			    }
		      }).then(function (success){
		    	  
		    	  $state.reload();
		   	   },function (error){
		   		   console.log(error);
		   	   });
		}
	 formsAdminCtrl.ajouterEtudiant = function(){
		 formsAdminCtrl.nouveauEtudiant.dateDeCreation = new Date();
			$http({
				method: 'POST',
		      url: '/etudiants',
		      dataType: 'json',
		      data    : formsAdminCtrl.nouveauEtudiant,
		      headers : {
			        'Content-Type' : 'application/json'
			    }
		      }).then(function (success){
		    	  
		    	  $state.reload();
		   	   },function (error){
		   		   console.log(error);
		   	   });
		}
	 formsAdminCtrl.doUploadImage = function(nb){
		 var file;
		 if(nb == 1){
			 file  = formsAdminCtrl.uploadedImage1;
		 }
		 else if(nb == 2){
			 file  = formsAdminCtrl.uploadedImage2;
		 }
	        
	        SharedData.uploadImage(file).then(function (response) {
	        	 if(nb == 1){
	        		 formsAdminCtrl.nouveauEtudiant.photo = JSON.parse(response.data);
	    		 }
	    		 else if(nb == 2){
	    			 formsAdminCtrl.nouveauEnseignant.photo = JSON.parse(response.data);
	    		 }
	        	
	 		}, function (err) {
	 			console.log(err);
	 		});
	     };
})
.controller('StatAdminController',function($http,$state,SharedData){
	var statAdminCtrl = this;
	statAdminCtrl.etudiantsDataIns = [0,0,0,0,0,0,0,0,0,0,0,0];
	statAdminCtrl.enseignantsDataIns = [0,0,0,0,0,0,0,0,0,0,0,0];
	statAdminCtrl.etudiants = [];
	statAdminCtrl.classeLabels = [];
	statAdminCtrl.classeData = [];
	statAdminCtrl.nbreAdmis = [0,0,0,0,0];
	statAdminCtrl.nbreRefuses = [0,0,0,0,0];
	   var anneeCourante = new Date().getYear() + 1900;
	statAdminCtrl.labels = [anneeCourante-5,anneeCourante-4,anneeCourante-3,anneeCourante-2,anneeCourante-1];
	statAdminCtrl.seriesAdmission = ['Admis', 'Refusé'];

	statAdminCtrl.data = [
      [65, 59, 80, 81, 56],
      [28, 48, 40, 19, 10]
    ];
	
	SharedData.getEtudiants().then(function(rep){
	   statAdminCtrl.etudiants = rep.data;
	   statAdminCtrl.annees = [anneeCourante-2,anneeCourante-1];
	   angular.forEach(statAdminCtrl.etudiants,function(value){
		   if(value.dateDeCreation != null){
			  
			   var date = new Date(value.dateDeCreation);
			   var indice = date.getMonth();
			   statAdminCtrl.etudiantsDataIns[indice]++;
		   }
	   });
	   
   });
   $http({
		method: 'GET',
      url: '/enseignants'
   }).then(function(rep){
	   statAdminCtrl.enseignants = rep.data;
	   statAdminCtrl.nombreEnseignants = statAdminCtrl.enseignants.length;
	   angular.forEach(statAdminCtrl.enseignants,function(value){
		   if(value.dateDeCreation != null){
		   var date = new Date(value.dateDeCreation);
		   
			   var indice = date.getMonth();
			   statAdminCtrl.enseignantsDataIns[indice]++;
		   }
		   
		   });
   });
   $http({
		method: 'GET',
     url: '/classes'
  }).then(function(success){
	   statAdminCtrl.classes = success.data;
	   angular.forEach(statAdminCtrl.classes,function(value,key){
		   if(value.idClasse != "inconnu"){
			   statAdminCtrl.classeLabels.push(value.idClasse);
			   
			   $http({
					method: 'GET',
			     url: '/listesetudiants/'+value.idClasse
			  }).then(function(rep){
				  statAdminCtrl.classeData.push(rep.data.length);
			  });
					   
						   
			   }
				   
		   
		   });
  });
   statAdminCtrl.test = [];
   statAdminCtrl.test[5] = 1;
   $http({
		method: 'GET',
      url: '/cours'
   }).then(function(success){
	   statAdminCtrl.cours = success.data;
	   statAdminCtrl.nombreCours = statAdminCtrl.cours.length;
   });
   
   angular.forEach(statAdminCtrl.etudiants,function(value){
	   if(value.etat == 'confirmee')
		   statAdminCtrl.nombreEtudiantsCourrant = statAdminCtrl.nombreEtudiantsCourrant +1;
	   else if(value.etat == 'diplomee')
		   statAdminCtrl.nombreEtudiantsDiplomee = statAdminCtrl.nombreEtudiantsDiplomee +1;
   });
   
	statAdminCtrl.monthLabels = ["Janvier", "Fevrier", "Mars", "Avril", "Mai", "Juin",
		"Juillet","Aout","Septembre","Octobre","Novembre","Decembre"];
	statAdminCtrl.series = ['Etudiants','Enseignants'];
	statAdminCtrl.data = [
	    [65, 59, 80, 81, 56, 55, 40, 19, 86, 27, 90, 59],
	    [28, 48, 40, 19, 86, 27, 90, 59, 80, 81, 56,]
	  ];
	
	
	
	statAdminCtrl.labels2 = ["Download Sales", "In-Store Sales", "Mail-Order Sales", "Tele Sales", "Corporate Sales","ert","lkio"];
	statAdminCtrl.data2 = [300, 500, 100, 40, 120,10,45];
	statAdminCtrl.type2 = 'pie';
	    
	    
	
	statAdminCtrl.datasetOverride = [{ yAxisID: 'y-axis-1' }, { yAxisID: 'y-axis-2' }];
	statAdminCtrl.options = {
	    scales: {
	      yAxes: [
	        {
	          id: 'y-axis-1',
	          type: 'linear',
	          display: true,
	          position: 'left'
	        },
	        {
	          id: 'y-axis-2',
	          type: 'linear',
	          display: true,
	          position: 'right'
	        }
	      ]
	    }
	  };
	  
	  

	   
	   
	   
	   
})		
.controller('IndexController',function($http,$state,$cookies,SharedData){
	var indexCtrl = this;
	$http.get('/etudiants/username/anonyme').then(function(resp){
	      $cookies.putObject(resp.data);
	    });
	
})	
.controller('notifsController',function($http,$state,$cookies,SharedData,$scope){
	$scope.notifications={};
	$http.get('/notifications').then(function(resp){
	      $scope.notifications=resp.data;
	    });
	
})	
.controller('BlogController',function($http,$cookies,$state,SharedData)
	{
		var blogCtrl = this;
		blogCtrl.title = "Forum";
	    blogCtrl.posts = {};
	    blogCtrl.getBlogs = function()
	    {
	    	$http.get('/posts').then(function(resp){
	  	      blogCtrl.posts = resp.data;
	  	    });
	    }
	    
	    blogCtrl.currentPage = 0;
	    blogCtrl.pageSize = 4;

	     
	    blogCtrl.tab = 'blog';
	    
	    blogCtrl.selectTab = function(setTab){
	      blogCtrl.tab = setTab;
	    };
	    
	    blogCtrl.isSelected = function(checkTab){
    	
	      return blogCtrl.tab === checkTab;
	    };
	     
	    blogCtrl.post = {commentairesId:[]};
	    blogCtrl.commentaire ={};
	    blogCtrl.post.idUtilisateur ="5ac79ac58500fe0c2cf03341"; //utilisateur.idEtudiant;
    
    	$http({method:'GET',url:'/etudiants/5ad9a9f09842b41f4482b56e'}).then(function(resp){
			if(resp.status == 200){
				blogCtrl.anonyme =  resp.data;	
			}
    	});
	    blogCtrl.getCommentaires = function(post){
	    	blogCtrl.commentaires = [];
	    		angular.forEach(post.commentairesId,function(commentaireId){
	    			$http({method:'GET',url:'/commentaires/'+ commentaireId}).then(function(resp){
		    			if(resp.status == 200){
		    				blogCtrl.commentaires.push(resp.data);
		    			}
	    		})
	    		
	    	})
	    } 
	    blogCtrl.addPost = function(){
	    	blogCtrl.post.etudiant = blogCtrl.anonyme;
	    	blogCtrl.post.commentaires = [];
	    	blogCtrl.post.dateDeCreation = new Date();
    		$http({
	 			method: 'POST',
	 	      url: '/posts',
	 	      dataType: 'json',
	 	      data    :blogCtrl.post,
	 	      headers : {
	 		        'Content-Type' : 'application/json'
	 		    }
    		}).then(function(resp){
			blogCtrl.post ={};
			blogCtrl.getBlogs();
	  	    });

	      
	    }; 
	    blogCtrl.voirPoste = function(post){
	    	$cookies.put('posteId',post.idPost);
	    	$state.transitionTo('poste');
	    }
	    blogCtrl.addCommentaire = function(idPost){
	    	blogCtrl.commentaire.idPost = idPost;
	    	blogCtrl.commentaire.idUtilisateur = utilisateur.idEtudiant;
	    	blogCtrl.commentaire.dateDeCreation = new Date();
    		$http({
	 			method: 'POST',
	 	      url: '/commentaires',
	 	      dataType: 'json',
	 	      data    :blogCtrl.commentaire,
	 	      headers : {
	 		        'Content-Type' : 'application/json'
	 		    }
    		}).then(function(resp){
			blogCtrl.getBlogs();
			blogCtrl.post ={};
			blogCtrl.commentaire ={};
	  	    });

	      
	    };
	    
	    blogCtrl.getBlogs();
	})	
.controller('PosteController',function($http ,$state,$cookies)
	{
		var posteCtrl = this;
		$http({method:'GET',url:'/posts/'+$cookies.get('posteId')}).then(function(resp){
			if(resp.status == 200){
				posteCtrl.post = resp.data;
			}
    	});
		$http({method:'GET',url:'/etudiants/5ad9a9f09842b41f4482b56e'}).then(function(resp){
			if(resp.status == 200){
				posteCtrl.anonyme =  resp.data;	
			}
    	});
		
		posteCtrl.addCommentaire = function(){
			posteCtrl.commentaire.idPost=posteCtrl.post.idPost ;
			posteCtrl.commentaire.utilisateur = posteCtrl.anonyme;
			posteCtrl.commentaire.dateDeCreation = new Date();
			$http({method:'POST',url:'/commentaires',dataType: 'json',data:posteCtrl.commentaire});
			$state.reload();
		}
		posteCtrl.jaime = function(com){
			com.jaime = com.jaime + 1;
			$http({
		 		method: 'PUT',
		 	    url: '/commentaires/'+com.idCommentaire,
		 	    dataType: 'json',
		 	    data    : com,
		 	    headers : {
		 		      'Content-Type' : 'application/json'
		 		  }
		 	    });
		}
	})	
.controller('StatistiquesController',function($http)
	{
	var statistiquesCtrl = this;
	var name="khay";
	var id="1";

    
	
	statistiquesCtrl.labels = ["Septembre","Octobre","Novembre","Decembre","Janvier", "Fevrier", "Mars", "Avril", "Mai", "Juin",
		"Juillet","Aout"];
	statistiquesCtrl.series = ['Enseignants', 'Etudiants'];
	statistiquesCtrl.data = [
	    [65, 59, 80, 81, 56, 55, 40, 19, 86, 27, 90, 59],
	    [28, 48, 40, 19, 86, 27, 90, 59, 80, 81, 56,]
	  ];
	
	statistiquesCtrl.labels2 = ["Download Sales", "In-Store Sales", "Mail-Order Sales", "Tele Sales", "Corporate Sales","ert","lkio"];
	statistiquesCtrl.data2 = [300, 500, 100, 40, 120,10,45];
	statistiquesCtrl.type2 = 'pie';
	    
	    
	statistiquesCtrl.onClick = function (points, evt) {
	    console.log(points, evt);
	  };
	  statistiquesCtrl.datasetOverride = [{ yAxisID: 'y-axis-1' }, { yAxisID: 'y-axis-2' }];
	  statistiquesCtrl.options = {
	    scales: {
	      yAxes: [
	        {
	          id: 'y-axis-1',
	          type: 'linear',
	          display: true,
	          position: 'left'
	        },
	        {
	          id: 'y-axis-2',
	          type: 'linear',
	          display: true,
	          position: 'right'
	        }
	      ]
	    }
	  };
	  
	  $http({
			method: 'GET',
	      url: '/etudiants'
	   }).then(function(rep){
		   statistiquesCtrl.etudiants = rep.data;
		   
	   });
	   
	   $http({
			method: 'GET',
	      url: '/enseignants'
	   }).then(function(rep){
		   statistiquesCtrl.enseignants = rep.data;
		   statistiquesCtrl.nombreEnseignants = statistiquesCtrl.enseignants.length;
	   });
	   console.log(statistiquesCtrl.nombreEnseignants);
	   $http({
			method: 'GET',
	      url: '/cours'
	   }).then(function(rep){
		   statistiquesCtrl.cours = rep.data;
		   statistiquesCtrl.nombreCours = statistiquesCtrl.cours.length;
		   console.log(statistiquesCtrl.nombreCours);
	   });
	   angular.forEach(statistiquesCtrl.enseignants,function(value){
		   if(value.etat == 'confirmee')
			   statistiquesCtrl.nombreEtudiantsCourrant = statistiquesCtrl.nombreEtudiantsCourrant +1;
		   else if(value.etat == 'diplomee')
			   statistiquesCtrl.nombreEtudiantsDiplomee = statistiquesCtrl.nombreEtudiantsDiplomee +1;
	   });

	   
	   
	   
	   
	    
	   
	   
})
.controller('adminMessagesController',function($scope,$http,$state,$stateParams,$rootScope){
	
	$scope.getMessagePublique = function(){
		
	
	$http({
		method: 'GET',
      url: "/messagespubliques"
   }).then(function (success){
	   
	   $scope.listemessagespubliques =  success.data;
	   
   },function (error){
	   console.log(error)
   });
	
	}
	 $http({
	      
			method: 'GET',
	      url:"http://localhost:8080/notifications"
	   }).then(function (success){
		   $scope.notificationss = success.data;

},function (error){
		   console.log(error)
	   });
	$scope.getMessagePublique();
	$scope.lire = function(m){
		m.lu = true;
		$http({
			method: 'PUT',
	      url: "/messagespubliques/"+m.idMessagePublique,
	      data:m
	   }).then(function(rep){
		   $state.reload();
	   })
	}
	$scope.toggleImportance = function(m){
		m.important = !m.important;
		$http({
			method: 'PUT',
	      url: "/messagespubliques/"+m.idMessagePublique,
	      data:m
	   }).then(function(rep){
		   $scope.getMessagePublique();
	   })
	}
	$scope.isLu = function(lu){
		if(lu == true){
			return "";
		}
		else if(lu == false){
			return "important";
		}
		
	}
	
	
	
})
.controller('retouretudiantController',function($scope,$http,$state,$cookies,$stateParams,$rootScope){
	$scope.etudiant = $cookies.getObject('etudiant');
	$scope.deconnecter = function(){
		
		 if($scope.etudiant != null)
			 {
			 $http({
			      	
					method: 'PUT',
			      url:"http://localhost:8080/deconnexion/"+$scope.etudiant.idClasse
			   }).then(function (success){
				   $scope.ress = success.data;
	             
	          //   $window.location.reload();
	  },function (error){
				   console.log(error)
			   });   
			$rootScope.etudiant={};
			 }

			$cookies.remove('etudiant');
			$state.go("loginetudiant");
		
	}
	
})
.controller('retourenseignantController',function($scope,$http,$state,$stateParams,$rootScope,$cookies){

	$scope.deconnecter = function(){
		
		//$rootScope.enseignant={};
		$cookies.remove('enseignant');
		$state.go("loginenseignant");
		
	}
	
})
.controller('retourController',function($scope,$http,$state,$stateParams,$rootScope){

	$scope.deconnecter = function(){
		console.log("hcen");
		$state.go("login");
	}
	
})
.controller('confirmerController',function($scope,$http,$state,$stateParams,$rootScope,$cookies,SharedData){
	$scope.etudiant={};
	SharedData.getClasses().then(function (success){
    	 $scope.classes = success.data;
	   },function (error){
		   console.log(error);
	   });
	 
	$http({
		method: 'GET',
      url: '/etudiantsnonenregistre'
   }).then(function (success){
	   
	   $scope.listeetudiantsnonconfirmes =  success.data;
	   
   },function (error){
	   console.log(error)
   });
	
	$scope.getSelectedEtudiant = function(id){
		$http({
			method: 'GET',
	      url: '/etudiantnonenregistre/'+id
	   }).then(function (success){
		   $scope.selectedEtudiant = success.data;
		   $cookies.putObject('profilCookies',$scope.selectedEtudiant);
		   $state.transitionTo('profil');
	   },function (error){
		   console.log(error);
	   });
	}
	$scope.confirmer = function(idclasse,id){
		$http({
			method: 'post',
	      url: '/etudiantnonenregistre/'+id+"/"+idclasse
	   }).then(function (success){
		   $scope.res=success.data;
		   $state.reload();
	   },function (error){
		   console.log(error);
	   });
	}
	$scope.supprimer = function(id){
		$http({
			method: 'delete',
	      url: '/deletenonenregistre/'+id
	   }).then(function (success){
		   $scope.res=success.data;
		   $state.reload();
	   },function (error){
		   console.log(error);
	   });
	}
})
.controller("registerCtrl",function($http,$cookies,$state,SharedData,$rootScope,$scope){
	$rootScope.etatGeneral="true";
	var registerCtrl = this;
	registerCtrl.sexes = SharedData.sexes;
	console.log(registerCtrl.sexes);
	
	// registerCtrl.user = {photo : {urlPath : "http://localhost:8080/files/unkown.png"}};
	$scope.etudiant={};
	$scope.sexes=registerCtrl.sexes ;
	registerCtrl.selectedEtudiant = {};
	registerCtrl.classes = [];
	

	
	
	registerCtrl.updatePhoto = function(){
		registerCtrl.user.photo = SharedData.updateUnkownPhoto($scope.etudiant.sexe);
	}
	
	$scope.ajouter = function(){
		 $scope.etudiant.dateDeCreation = new Date();
		$scope.etudiant.photo = SharedData.updateUnkownPhoto($scope.etudiant.sexe);
		//console.log($scope.etudiant.age);
		$http({
			method: 'POST',
	      url: '/etudiantsnonenregistre',
	      dataType: 'json',
	      data    : $scope.etudiant,
	      headers : {
		        'Content-Type' : 'application/json'
		    }
	      }).then(function (success){
	    	  
	    	  console.log($scope.etudiant);
	    	 
	   	   },function (error){
	   		   console.log(error);
	   	   });
	}
	registerCtrl.doUploadImage = function(){
        var file = registerCtrl.uploadedImage;
        SharedData.uploadImage(file).then(function (response) {
        	registerCtrl.user.photo = JSON.parse(response.data);
 		}, function (err) {
 			console.log(err);
 		});
     };
     
     
	
})

.controller('contacterResponsablesController',function($scope,$http,$state,$stateParams,$rootScope,SharedData){

	$scope.email={};
	SharedData.getClasses().then(function (success){
   	 $scope.classes = success.data;
	   },function (error){
		   console.log(error);
	   });
	
	$scope.envoyer=function(){
		console.log($scope.email.inclusion);
		console.log($scope.email.classe);
		
		 $http({
		      
				method: 'GET',
		      url:"http://localhost:8080/mail/"+String($scope.mail)+"/"+String($scope.email.inclusion)+"/"+String($scope.email.classe)
		   }).then(function (success){
			   alert($scope.mail);
			   $scope.notifications = success.data;

	},function (error){
			   console.log(error)
		   });
		  
		    };
	
	
})
.controller('lesNotificationsController',function($scope,$http,$state,$stateParams,$rootScope){

	 $http({
	      
			method: 'GET',
	      url:"http://localhost:8080/notifications/enseignant/"+String($rootScope.enseignant.username)
	   }).then(function (success){
		   $scope.notifications = success.data;

},function (error){
		   console.log(error)
	   });
	 
	
	
})
.controller('acceuilController',function($http,$state,$stateParams,$rootScope){

	
	var acceuilCtrl = this;
	
	
	acceuilCtrl.nombre=5;
	$http({
		method: 'GET',
      url: '/cours'
   }).then(function (success){
	   acceuilCtrl.cours = success.data;
	   angular.forEach(acceuilCtrl.cours,function(value,key){
		   $http({
				method: 'GET',
		      url: '/enseignants/'+acceuilCtrl.cours[key].idEnseignant
		   }).then(function(resp){
			   acceuilCtrl.cours[key].enseignant = resp.data;
		   });
	   });
	
	
   });
	 
	
})
.controller('passerExamenController',function($scope,$http,$state,$stateParams,$rootScope){
$scope.n={};
 $scope.examen=$rootScope.examen.contenuExamen;
 $scope.repondre=function(){
	 $scope.n.classe= $rootScope.etudiant.idClasse;
		$scope.n.contenu="L'etudiant " + String($rootScope.etudiant.username)+" a passer un examen ";
		$http({
			method: 'POST',
	      url: "/notifications",
	      dataType: 'json',
	      data    : $scope.n,
	      headers : {
		        'Content-Type' : 'application/json'
		    }
	      }).then(function (success){
	    	  console.log(success.data);
	   	   },function (error){
	   		   console.log(error);
	   	   });
	  
	    };
	
})
.controller('listeExamensController',function($scope,$http,$state,$stateParams,$rootScope){
 
	 $http({
	      
			method: 'GET',
	      url:"http://localhost:8080/examens/classe/"+String($rootScope.etudiant.idClasse)
	   }).then(function (success){
		   $scope.examens = success.data;

},function (error){
		   console.log(error)
	   });
	 $scope.acceder=function(examen){
	   //  $scope.doc=doc;
	     $rootScope.examen=examen;
	     $scope.examen=$rootScope.examen;
	    //  alert($scope.urlPath);
	        $state.go("passerExamen",{
	            classe:$scope.examen.classeExamen,
	           // nomFichier:doc.nomFichier
	            // username:$scope.username
	        });
	    };


})
.controller('contenuQuizController',function($scope,$cookies,SharedData,$window,$rootScope,$http,$state)
	{
	$scope.liste=[1,2,3];
	$scope.q={};
	$scope.n={};
	  $scope.quiz=$cookies.getObject('quiz');
	  $scope.etudiant = $cookies.getObject('etudiant');
	var quizs;
			$http({
				method: 'GET',
		      url: '/quizs'
		   }).then(function (success){
			   $scope.quizs = success.data;
		   },function (error){
			   console.log(error)
		   });
			
			$scope.b=$scope.quiz["question"];
			$scope.reponses=$scope.quiz["reponses"];
			alert($scope.reponses);
			$scope.b0=$scope.b[0]["question"];   $scope.c0=$scope.b[1]["question"];
			$scope.b1=$scope.b[0]["reponses"][0];$scope.c1=$scope.b[1]["reponses"][0];
			$scope.b2=$scope.b[0]["reponses"][1];$scope.c2=$scope.b[1]["reponses"][1];
			$scope.b3=$scope.b[0]["reponses"][2];$scope.c3=$scope.b[1]["reponses"][2];
			
			
			$scope.d0=$scope.b[2]["question"];       $scope.e0=$scope.b[3]["question"];
			$scope.d1=$scope.b[2]["reponses"][0];$scope.e3=$scope.b[3]["reponses"][2];
			$scope.d2=$scope.b[2]["reponses"][1];$scope.e2=$scope.b[3]["reponses"][1];
			$scope.d3=$scope.b[2]["reponses"][2];$scope.e1=$scope.b[3]["reponses"][0];
			$scope.f0=$scope.b[4]["question"];$scope.g0=$scope.b[5]["question"];
			$scope.f1=$scope.b[4]["reponses"][0];$scope.g1=$scope.b[5]["reponses"][0];
			$scope.f2=$scope.b[4]["reponses"][1];$scope.g2=$scope.b[5]["reponses"][1];
			$scope.f3=$scope.b[4]["reponses"][2];$scope.g3=$scope.b[5]["reponses"][2];
			
			
			
			
	
			$scope.h0=$scope.b[6]["question"];
			$scope.h1=$scope.b[6]["reponses"][0];
			$scope.h2=$scope.b[6]["reponses"][1];
			$scope.h3=$scope.b[6]["reponses"][2];
			$scope.i0=$scope.b[7]["question"];
			$scope.i1=$scope.b[7]["reponses"][0];
			$scope.i2=$scope.b[7]["reponses"][1];
			$scope.i3=$scope.b[7]["reponses"][2];
			$scope.j0=$scope.b[8]["question"];
			$scope.j1=$scope.b[8]["reponses"][0];
			$scope.j2=$scope.b[8]["reponses"][1];
			$scope.j3=$scope.b[8]["reponses"][2];
			$scope.k0=$scope.b[9]["question"];
			$scope.k1=$scope.b[9]["reponses"][0];
			$scope.k2=$scope.b[9]["reponses"][1];
			$scope.k3=$scope.b[9]["reponses"][2];
			 
			 $scope.valider = function(){
				 $scope.resultat=String($scope.r0)+String($scope.r1)+String($scope.r2)+String($scope.r3)+String($scope.r4)+String($scope.r5)+String($scope.r6)+String($scope.r7)+String($scope.r8)+String($scope.r9);
			$scope.testQuestions= new Array();
				 if($scope.resultat==$scope.reponses)
				{
				alert("reponses correctes");
				$scope.q.valeur=10;
				$scope.q.etudiant=$scope.etudiant.username;
				$scope.q.cours=$scope.quiz.nomcours;
				$http({
		 			method: 'POST',
		 	      url: "/notes",
		 	      dataType: 'json',
		 	      data    : $scope.q,
		 	      headers : {
		 		        'Content-Type' : 'application/json'
		 		    }
		 	      }).then(function (success){
		 	    	  console.log(success.data);
		 	   	   },function (error){
		 	   		   console.log(error);
		 	   	   });
				$scope.n.classe= $scope.etudiant.idClasse;
				$scope.n.contenu="L'etudiant " + $scope.etudiant.username+" a eu 10 dans un quiz du cours "+ $scope.quiz.nomcours;
				$http({
		 			method: 'POST',
		 	      url: "/notifications",
		 	      dataType: 'json',
		 	      data    : $scope.n,
		 	      headers : {
		 		        'Content-Type' : 'application/json'
		 		    }
		 	      }).then(function (success){
		 	    	  console.log(success.data);
		 	   	   },function (error){
		 	   		   console.log(error);
		 	   	   });
				}
			else
				{
				for(var i=0;i<10;i++)
					{
					if($scope.resultat[i]!=$scope.reponses[i])
						{
						$scope.testQuestions.push(i+1);
						}
					}
				$scope.fautes="";
				for(var j=0;j<$scope.testQuestions.lenght;j++)
					{
					$scope.fautes=String($scope.fautes)+String($scope.testQuestions[j]);
					}
				alert("votre réponses fausses sont" + String($scope.testQuestions));
				$scope.q.etudiant=$scope.etudiant.username;
				$scope.q.quiz=$scope.quiz.nomcours;
				
				$scope.q.valeur=10-$scope.testQuestions.length;
				
				$http({
		 			method: 'POST',
		 	      url: "/notes",
		 	      dataType: 'json',
		 	      data    : $scope.q,
		 	      headers : {
		 		        'Content-Type' : 'application/json'
		 		    }
		 	      }).then(function (success){
		 	    	  console.log(success.data);
		 	   	   },function (error){
		 	   		   console.log(error);
		 	   	   });
				$scope.n.classe= $scope.etudiant.idClasse;
				$scope.n.contenu="L'etudiant " + $scope.etudiant.username+" a eu "+ $scope.q.valeur+" dans un quiz du cours "+ $scope.quiz.nomcours ;
				$http({
		 			method: 'POST',
		 	      url: "/notifications",
		 	      dataType: 'json',
		 	      data    : $scope.n,
		 	      headers : {
		 		        'Content-Type' : 'application/json'
		 		    }
		 	      }).then(function (success){
		 	    	  console.log(success.data);
		 	   	   },function (error){
		 	   		   console.log(error);
		 	   	   });
				}
			 }
	     
	})
.controller('passerQuizController',function($scope,$cookies,SharedData,$window,$rootScope,$http,$state)
	{
	$scope.etudiant = $cookies.getObject('etudiant');
	 $http({
	      
			method: 'GET',
	      url:"http://localhost:8080/quizs/classe/"+$scope.etudiant.idClasse
	   }).then(function (success){
		   $scope.quizs = success.data;
  },function (error){
		   console.log(error)
	   });
	 $scope.acceder=function(quiz){
	   //  $scope.doc=doc;
	     $rootScope.quiz=quiz;
	     $cookies.putObject('quiz',quiz);
	      $scope.nomcours=quiz.nomcours;
	    //  alert($scope.urlPath);
	        $state.go("contenuQuiz",{
	            nomcours:$scope.nomcours,
	           // nomFichier:doc.nomFichier
	            // username:$scope.username
	        });
	    };
  
  
	})
.controller('fichierController',function($scope,$http,$state,$stateParams,$rootScope){
  // $scope.source="http://localhost:8080/files/eaxmenJEEfinalJanvier2017.pdf";
  //  alert("hcen"+$stateParams.urlpath);
  
    $scope.urlPath=$rootScope.document.urlPath;
    //  console.log($scope.urlpath);
})
.controller('listeCoursEtudiantController',function($scope,$cookies,SharedData,$window,$rootScope,$http,$state)
	{
	$scope.etudiant = $cookies.getObject('etudiant');
	$http({
		method: 'GET',
      url: "http://localhost:8080/cours/classe/"+$scope.etudiant.idClasse
   }).then(function (success){
	   $scope.listesCours = success.data;
	   angular.forEach($scope.listesCours,function(value,key){
		   $http({
				method: 'GET',
		      url: '/enseignants/'+$scope.listesCours[key].idEnseignant
		   }).then(function(resp){
			   $scope.listesCours[key].enseignant = resp.data;
		   });
	   });
		   
	   	   
	   });
	$scope.m_a_jNbreLecture = function(c){
		c.nbreDeVus = c.nbreDeVus + 1 ;
		   $http({
	 			method: 'PUT',
	 	      url: '/cours/'+c.idCours,
	 	      dataType: 'json',
	 	      data    : c,
	 	      headers : {
	 		        'Content-Type' : 'application/json'
	 		    }
	 	      });
	   }
	 $http({
	      
			method: 'GET',
	      url:"http://localhost:8080/cours/classe/"+$scope.etudiant.idClasse
	   }).then(function (success){
		   $scope.cours = success.data;
  
  },function (error){
		   console.log(error)
	   });
	 $scope.acceder=function(doc){
	     $scope.doc=doc;
	     $rootScope.document=doc;
	     $cookies.putObject('doc',doc);
	      $scope.urlPath=doc.urlPath;
	    //  alert($scope.urlPath);
	        $state.go("fenetrefichier",{
	            urlpath:$scope.urlPath,
	           // nomFichier:doc.nomFichier
	            // username:$scope.username
	          //  $window.open(urlpath);
	        });
	    };
  
  
	})
.controller('classeEtudiantController',function($scope,$cookies,SharedData,$window,$rootScope,$http,$state)
	{
	//$rootScope.name;
	//var a=String($scope.user.username);
	//alert("hcen");
	$scope.etudiant = $cookies.getObject('etudiant');
	
    $scope.un= "/etudiants/parclasseid/"+$scope.etudiant.idClasse;
//   console.log(a);
      $http({
  
			method: 'GET',
	      url:$scope.un
	   }).then(function (success){
		   $scope.etuds = success.data;
         
        
//    console.log($scope.users.mail); 
	   },function (error){
		   console.log(error)
	   });
    

		
	})
.controller('etudiantProfilController',function($scope,$cookies,SharedData,$window,$rootScope,$http,$state)
	{
	//$rootScope.name;
	//var a=String($scope.user.username);
	//alert("hcen");
	
    $scope.un= "http://localhost:8080/etudiants/username/"+$cookies.getObject('etudiant').username;
//   console.log(a);
      $http({
  
			method: 'GET',
	      url:$scope.un
	   }).then(function (success){
		   $scope.etudiant = success.data;
         
          $rootScope.etudiant=$scope.etudiant;
          $scope.urlPath=$scope.etudiant.photo.urlPath;
           $scope.usern=$scope.etudiant.username;   
          $scope.classe=$scope.etudiant.idClasse;
          $http({
    	      
  			method: 'GET',
  	      url:"http://localhost:8080/cours/classe/"+String($scope.etudiant.idClasse)
  	   }).then(function (success){
  		   $scope.cours = success.data;

  },function (error){
  		   console.log(error)
  	   });
//    console.log($scope.users.mail); 
	   },function (error){
		   console.log(error)
	   });
      

		
	})
.controller('loginetudiantCtrl',function($scope,$cookies,SharedData,$window,$rootScope,$http,$state)
	{
	//$rootScope.etatGeneral="true";
	 $scope.user={};
	    $scope.authentifier=function(){
	        /*$state.go("fichier",{
	            nomFichier:doc.nomFichier
	        });*/
	        var a=String($scope.user.username);
	        $scope.un= "http://localhost:8080/etudiants/username/"+String($scope.user.username);
	    //   console.log(a);
	          $http({
	      
					method: 'GET',
			      url:$scope.un
			   }).then(function (success){
				   $scope.users = success.data;
	             
	              
	              if($scope.users.username==null)
	                  {
	                    //  $scope.message="ce compte n'existe pas";
	            	  alert("ce compte n'existe pas");
	                  }
	               if(($scope.user.username==$scope.users.username)&&($scope.user.password==$scope.users.password)&&($scope.user.username!=null))
	                  {
	                       $http({
	      
					method: 'PUT',
			      url:"http://localhost:8080/connexion/"+String($scope.user.username)
			   }).then(function (success){
				   $scope.ress = success.data;
	               
	            //   $window.location.reload();
	    },function (error){
				   console.log(error)
			   });   
	            	   $rootScope.name=$scope.users.username;
	            	   $rootScope.etudiant=$scope.users;
	            	   $cookies.putObject('etudiant',$scope.users);
	            	   
	                    $state.go("etudiantProfil",{
	                    	
	            username:$scope.users.username
	                       
	        });
	                  }
	              
	   //    console.log($scope.users.mail); 
			   },function (error){
				   console.log(error)
			   });
	        
	    }
	
	
		
	})
.controller('examenEnseignantController',function($scope,$cookies,SharedData,$window,$rootScope,$http,$state)
	{
	var examenEnseignantController = this;
	$scope.idsClasses = $rootScope.enseignant.classesId ;
	//alert(examenEnseignantController.idsClasses);
//	console.log(coursEnseignantCtrl.idsClasses);
 
	 $scope.authentifier=function(){
	//	 var data = new FormData();
		// $scope.examen=[];
		//	$scope.examen.classeExamen=$scope.classeid;
		//	$scope.examen.contenuExamen=$scope.contenuexamen;
			//alert(data);
			var url = "/examens";
	$http.post(url, $scope.examen).then(function (response) {
		
    	//console.log(file);
    	$scope.ress=response.data;
    //	console.log(coursEnseignantCtrl.uploadedFile);
    	//alert(coursEnseignantCtrl.uploadedFile.name);
		}, function (response) {
			$scope.ress=response.data;
			
		});
	
	 }
	
    

		
	})
.controller('saisieQuizController',function($scope,$cookies,SharedData,$window,$rootScope,$http,$state)
	{
	var saisieQuizController =this;
	var quizCtrl = this;
	$scope.init = true;
	$scope.core = false;
	$scope.fin = false;
	quizCtrl.questiones = [];
	quizCtrl.quest = {question:"",reponses:[]};
	quizCtrl.compteur = 0;
	quizCtrl.reponses = "";
	quizCtrl.ajouterQuestion = function(rep){
		quizCtrl.quest.reponses.push(quizCtrl.rs0);
		quizCtrl.quest.reponses.push(quizCtrl.rs1);
		quizCtrl.quest.reponses.push(quizCtrl.rs2);
		quizCtrl.questiones.push(quizCtrl.quest);
		quizCtrl.quest = {question:"",reponses:[]};
		quizCtrl.rs0 = "";quizCtrl.rs1 = "";quizCtrl.rs2 = "";
		quizCtrl.compteur++;
		
		quizCtrl.reponses = quizCtrl.reponses + String(rep);
		console.log(quizCtrl.questiones);
	}
	quizCtrl.annuler = function(){
		quizCtrl.reponses = "";
		quizCtrl.questiones = [];
		quizCtrl.compteur = 0;
		quizCtrl.quest = {question:"",reponses:[]};
	}
	
	quizCtrl.saveQuiz = function(){
		console.log(quizCtrl.coursquiz);
	 		$http({
	 			method: 'POST',
	 	      url: '/quizs',
	 	      dataType: 'json',
	 	      data    :{
	 	    	    "nomcours" : quizCtrl.coursquiz,
	 	    	    "question" : quizCtrl.questiones,
	 	    	    "reponses" : quizCtrl.reponses
	 	    	} ,
	 	      headers : {
	 		        'Content-Type' : 'application/json'
	 		    }
	 	      }).then(function (success){
	 	    	  
	 	    	 
	 	    	  console.log(success.data);
	 	   	   },function (error){
	 	   		   console.log(error)
	 	   	   });
	 	}
	$scope.afficher = function(v){
		if(v == 'init')
			{
			$scope.init = true;
			$scope.core = false;
			$scope.fin = false;
			}
		else if(v == 'core')
			{
			$scope.core = true;
			$scope.init = false;
			$scope.fin = false;
			}
		else if(v == 'fin')
			{
			$scope.fin = true;
			$scope.core = false;
			$scope.init = false;
			}
	}
	$http({
		method: 'GET',
      url: '/cours'
   }).then(function (success){
	   $scope.listecours = success.data;
	 //  alert(saisieQuizController.listecours);
   },function (error){
	   console.log(error);
   });
	
	
	$scope.liste= [1,2,3];
	/*$scope.nombrequestions1=$scope.nombrequestions;
	$scope.lis=new Array($scope.nombrequestions);
	$scope.lis.push(1);
	$scope.lis.push(2);
	for(var i = 0;i<$scope.nombrequestions;i++)
		{
		$scope.lis.push(i);
		}
	*/
	$scope.reponses=$scope.reponse1+$scope.reponse2+$scope.reponse3+$scope.reponse4+$scope.reponse5+$scope.reponse6+$scope.reponse7+$scope.reponse8+$scope.reponse9+$scope.reponse10;
	var rep= $scope.reponse1+$scope.reponse2+$scope.reponse3+$scope.reponse4+$scope.reponse5+$scope.reponse6+$scope.reponse7+$scope.reponse8+$scope.reponse9+$scope.reponse10;
	$scope.quiz=[[$scope.question1,[$scope.reponse11,$scope.reponse12,$scope.reponse13]],[$scope.question1,[$scope.reponse11,$scope.reponse12,$scope.reponse13]]];
//	$scope.quiz.reponses=$scope.reponses;
	/* $scope.saveQuiz=function(){
	
		$http.post('http://localhost:8080/quizs',$scope.quiz).then(function(data){
			$scope.quiz=data;
		});
		
		
		
	} */
	 $scope.saveQuiz = function(){
		$scope.quiz=[[$scope.question1,[$scope.reponse11,$scope.reponse12,$scope.reponse13]],[$scope.question1,[$scope.reponse11,$scope.reponse12,$scope.reponse13]]];
	$scope.reponses=String($scope.reponse1)+String($scope.reponse2)+String($scope.reponse3)+String($scope.reponse4)+String($scope.reponse5)+String($scope.reponse6)+String($scope.reponse7)+String($scope.reponse8)+String($scope.reponse9)+String($scope.reponse10);
	
	/*var rep1=$scope.reponse1;
		var rep= rep1.concat($scope.reponse2);*/
 		$http({
 			method: 'POST',
 	      url: '/quizs',
 	      dataType: 'json',
 	      data    :{
 	    	    "nomcours" : String($scope.coursquiz),
 	    	    "question" : [ 
 	    	        {
 	    	            "question" : $scope.question1,
 	    	            "reponses" : [ 
 	    	            	$scope.proposition11, 
 	    	            	$scope.proposition12,
 	    	            	$scope.proposition13
 	    	            ]
 	    	        }, 
 	    	        {
 	    	            "question" : $scope.question2,
 	    	            "reponses" : [ 
 	    	            	$scope.proposition21, 
 	    	            	$scope.proposition22,
 	    	            	$scope.proposition23
 	    	            ]
 	    	        },
 	    	       {
 	    	            "question" : $scope.question3,
 	    	            "reponses" : [ 
 	    	            	$scope.proposition31, 
 	    	            	$scope.proposition32,
 	    	            	$scope.proposition33
 	    	            ]
 	    	        },
 	    	       {
 	    	            "question" : $scope.question4,
 	    	            "reponses" : [ 
 	    	            	$scope.proposition41, 
 	    	            	$scope.proposition42,
 	    	            	$scope.proposition43
 	    	            ]
 	    	        },
 	    	       {
 	    	            "question" : $scope.question5,
 	    	            "reponses" : [ 
 	    	            	$scope.proposition51, 
 	    	            	$scope.proposition52,
 	    	            	$scope.proposition53
 	    	            ]
 	    	        },
 	    	       {
 	    	            "question" : $scope.question6,
 	    	            "reponses" : [ 
 	    	            	$scope.proposition61, 
 	    	            	$scope.proposition62,
 	    	            	$scope.proposition63
 	    	            ]
 	    	        },
 	    	       {
 	    	            "question" : $scope.question7,
 	    	            "reponses" : [ 
 	    	            	$scope.proposition71, 
 	    	            	$scope.proposition72,
 	    	            	$scope.proposition73
 	    	            ]
 	    	        },
 	    	       {
 	    	            "question" : $scope.question8,
 	    	            "reponses" : [ 
 	    	            	$scope.proposition81, 
 	    	            	$scope.proposition82,
 	    	            	$scope.proposition83
 	    	            ]
 	    	        },
 	    	       {
 	    	            "question" : $scope.question9,
 	    	            "reponses" : [ 
 	    	            	$scope.proposition91, 
 	    	            	$scope.proposition92,
 	    	            	$scope.proposition93
 	    	            ]
 	    	        },
 	    	       {
	    	            "question" : $scope.question10,
	    	            "reponses" : [ 
	    	            	$scope.proposition101, 
	    	            	$scope.proposition102,
	    	            	$scope.proposition103
	    	            ]
	    	        }
 	    	    ],
 	    	    "reponses" : $scope.reponses
 	    	} ,
 	      headers : {
 		        'Content-Type' : 'application/json'
 		    }
 	      }).then(function (success){
 	    	  
 	    	 
 	    	  console.log(success.data);
 	   	   },function (error){
 	   		   console.log(error)
 	   	   });
 	}
	
    

		
	})
.controller('coursEnseignantCtrl',function($scope,$cookies,SharedData,$window,$rootScope,$http,$state)
	{
	var coursEnseignantCtrl = this;
	coursEnseignantCtrl.idsClasses = $rootScope.enseignant.classesId ;
//	console.log(coursEnseignantCtrl.idsClasses);
	var coursEnseignantCtrl = this;
	coursEnseignantCtrl.doGetFiles = function(){
       var url = "/getallfilesname";
       $http.get(url).then(function (response) {
    	   coursEnseignantCtrl.lstFiles = response.data;
		}, function (response) {
			alert(response.data);
		});
    };
    coursEnseignantCtrl.doUploadFile = function(){
        var file = coursEnseignantCtrl.uploadedFile;
        var url = "/uploadfile";
        
        var data = new FormData();
        data.append('uploadfile', file);
     
        var config = {
     	   	transformRequest: angular.identity,
     	   	transformResponse: angular.identity,
 	   		headers : {
 	   			'Content-Type': undefined
 	   	    }
        }
        
        $http.post(url, data, config).then(function (response) {

        	//console.log(file);
        	coursEnseignantCtrl.uploadResult=response.data;
        //	console.log(coursEnseignantCtrl.uploadedFile);
        	//alert(coursEnseignantCtrl.uploadedFile.name);
 		}, function (response) {
 			coursEnseignantCtrl.uploadResult=response.data;
 			
 		});
        var dataa=coursEnseignantCtrl.classesId;
        var urll="/classes/"+String(coursEnseignantCtrl.uploadedFile.name);
      //  alert(urll);
        $http({
 			method: 'POST',
 	      url: "/cours/"+String(coursEnseignantCtrl.uploadedFile.name),
 	      dataType: 'json',
 	      data    : coursEnseignantCtrl.classesId,
 	      headers : {
 		        'Content-Type' : 'application/json'
 		    }
 	      }).then(function (success){
 	    	  console.log(success.data);
 	   	   },function (error){
 	   		   console.log(error);
 	   	   });
        
        
     };
	
    

		
	})
.controller('classesEnseignantCtrl',function($scope,$cookies,SharedData,$window,$rootScope,$http,$state)
	{
	$scope.a=true;
	$scope.name=$rootScope.name;
	var classesEnseignantCtrl = this;
	classesEnseignantCtrl.activeClasse = null;
	classesEnseignantCtrl.listeEtudiants = null;
	classesEnseignantCtrl.idsClasses = $rootScope.enseignant.classesId ;
	// alert(classesEnseignantCtrl.idsClasses);
	classesEnseignantCtrl.getClasses = function(){
		$http({
			method: 'GET',
	      url: '/classes'+$rootScope.name
	   }).then(function (success){
		   classesCtrl.classes = success.data;
	   },function (error){
		   console.log(error);
	   });
	}
	classesEnseignantCtrl.getClasse = function(id){
		$http({
			method: 'GET',
	      url: '/classes/'+id
	   }).then(function (success){
		   classesEnseignantCtrl.activeClasse =  success.data;
	   },function (error){
		   console.log(error);
	   });
	}
	classesEnseignantCtrl.getActiveClasse = function(id){
		classesEnseignantCtrl.activeClasse = classesEnseignantCtrl.getClasse(id);
	}
	classesEnseignantCtrl.getEtudiantsParClasseId = function(id){
		
		$http({
			method: 'GET',
	      url: '/etudiants/parclasseid/'+id
	   }).then(function (success){
		   
		   classesEnseignantCtrl.listeEtudiants =  success.data;
		  
	   },function (error){
		   console.log(error);
	   });
		
	}
    

		
	})
.controller('enseignantProfilCtrl',function($scope,$cookies,SharedData,$window,$rootScope,$http,$state)
	{
	//$rootScope.name;
	//var a=String($scope.user.username);
	//alert("hcen");
	$scope.url="http://localhost:8080/files/unkown.png";
    $scope.un= "http://localhost:8080/enseignants/username/"+$cookies.getObject('enseignant').username;
//   console.log(a);
      $http({
  
			method: 'GET',
	      url:$scope.un
	   }).then(function (success){
		   $scope.enseignant = success.data;
         
          $rootScope.enseignant=$scope.enseignant;
          $scope.urlPath=$scope.enseignant.photo.urlPath;
           $scope.usern=$scope.enseignant.username;   
          $scope.classes=$scope.enseignant.classesId;
//    console.log($scope.users.mail); 
	   },function (error){
		   console.log(error)
	   });
    

		
	})
.controller('loginenseignantCtrl',function($scope,$cookies,SharedData,$window,$rootScope,$http,$state)
	{
	$rootScope.etatGeneral="true";
	 $scope.user={};
	    $scope.authentifier=function(){
	        /*$state.go("fichier",{
	            nomFichier:doc.nomFichier
	        });*/
	        var a=String($scope.user.username);
	        $scope.un= "http://localhost:8080/enseignants/username/"+String($scope.user.username);
	    //   console.log(a);
	          $http({
	      
					method: 'GET',
			      url:$scope.un
			   }).then(function (success){
				   $scope.users = success.data;
	             
	              
	              if($scope.users.username==null)
	                  {
	                    //  $scope.message="ce compte n'existe pas";
	            	  alert("ce compte n'existe pas");
	                  }
	               if(($scope.user.username==$scope.users.username)&&($scope.user.password==$scope.users.password)&&($scope.user.username!=null))
	                  {
	                      /*    $http({
	      
					method: 'PUT',
			      url:"http://localhost:8080/connexion/"+String($scope.user.username)
			   }).then(function (success){
				   $scope.ress = success.data;
	               
	            //   $window.location.reload();
	    },function (error){
				   console.log(error)
			   });   */
	            	   $rootScope.name=$scope.users.username;
	            	   $rootScope.enseignant=$scope.users;
	            	   $cookies.putObject('enseignant',$scope.users);
	                    $state.go("enseignantProfil",{
	                    	
	            username:$scope.users.username
	                       
	        });
	                  }
	              
	   //    console.log($scope.users.mail); 
			   },function (error){
				   console.log(error)
			   });
	        
	    }
	
		/*console.log(SharedData.etatGeneral);
		SharedData.etatGeneral="true";
		 $scope.aj=function(){
			 SharedData.etatGeneral="true";
			 $scope.etatGeneral=SharedData.etatGeneral;
				console.log(SharedData.etatGeneral);
				 $window.location.reload();
		    };
		    console.log(SharedData.etatGeneral);*/
		
	})
.controller('loginCtrl',function($scope,$cookies,SharedData,$window,$rootScope,$http,$state)
	{
	$scope.a=false;
	$rootScope.etatGeneral="true";
	 $scope.user={};
	    $scope.authentifier=function(){
	        /*$state.go("fichier",{
	            nomFichier:doc.nomFichier
	        });*/
	        var a=String($scope.user.username);
	        $scope.un= "http://localhost:8080/administrateurs/username/"+String($scope.user.username);
	    //   console.log(a);
	          $http({
	      
					method: 'GET',
			      url:$scope.un
			   }).then(function (success){
				   $scope.users = success.data;
	             
	              
	              if($scope.users.username==null)
	                  {
	                      $scope.message="ce compte n'existe pas";
	                  }
	               if(($scope.user.username==$scope.users.username)&&($scope.user.password==$scope.users.password)&&($scope.user.username!=null))
	                  {
	                      /*    $http({
	      
					method: 'PUT',
			      url:"http://localhost:8080/connexion/"+String($scope.user.username)
			   }).then(function (success){
				   $scope.ress = success.data;
	               
	            //   $window.location.reload();
	    },function (error){
				   console.log(error)
			   });   */
	            	   $rootScope.name=$scope.users.username;
	                    $state.go("classes",{
	            username:$scope.users.username
	                       
	        });
	                  }
	              
	   //    console.log($scope.users.mail); 
			   },function (error){
				   console.log(error)
			   });
	        
	    }
	
		/*console.log(SharedData.etatGeneral);
		SharedData.etatGeneral="true";
		 $scope.aj=function(){
			 SharedData.etatGeneral="true";
			 $scope.etatGeneral=SharedData.etatGeneral;
				console.log(SharedData.etatGeneral);
				 $window.location.reload();
		    };
		    console.log(SharedData.etatGeneral);*/
		
	})
.controller('UtilisateurController',function($http,$cookies,$state,SharedData)
	{
		var utilisateurCtrl = this;
		utilisateurCtrl.utilisateur = $cookies.getObject('loginUtilisateur');
		utilisateurCtrl.test = SharedData.test;
	})
.controller('PublicController',function($http,$cookies,$state,SharedData,$scope,$location)
	{
	$scope.isActive = function(viewLocation) {
	    return viewLocation === $location.path();
	};
	$scope.nombrecours="";
	$scope.nombre=5;
	 var publicCtrl = this;
	 SharedData.getClasses().then(function (success){
    	 $scope.cla= success.data;
    	 
	   },function (error){
		   console.log(error);
	   });
	 $http({
			method: 'GET',
	      url: '/etudiantsactifs'
	   }).then(function (success){
		   $scope.actifs = success.data;
	
	   },function (error){
		   console.log(error)
	   });
	 $http({
			method: 'GET',
	      url: '/allquizs'
	   }).then(function (success){
		   $scope.quizs = success.data;
		   $scope.nombreequizs=$scope.quizs.length ;
		  console.log($scope.nombreequizs);
	   },function (error){
		   console.log(error)
	   });
	 $http({
			method: 'GET',
	      url: '/cours'
	   }).then(function (success){
		   $scope.cours = success.data;
		   $scope.nombrecours= $scope.cours.length ;
		   console.log($scope.nombrecours);
		   publicCtrl.nombrecours=$scope.nombrecours;
		   console.log(publicCtrl.nombrecours);
	   },function (error){
		   console.log(error)
	   });
	 $http({
			method: 'GET',
	      url: '/classes'
	   }).then(function (success){
		   $scope.classes = success.data;
		   $scope.nombreclasses= $scope.classes.length ;
	   },function (error){
		   console.log(error)
	   });
	 $http({
			method: 'GET',
	      url: '/enseignants'
	   }).then(function (success){
		   $scope.enseignants = success.data;
		   $scope.nombreenseignants= $scope.enseignants.length ;
	   },function (error){
		   console.log(error)
	   });
	 $http({
			method: 'GET',
	      url: '/etudiants'
	   }).then(function (success){
		   $scope.etudiants = success.data;
		   $scope.nombreetudiants= $scope.etudiants.length ;	
	   },function (error){
		   console.log(error)
	   });
	 $http({
			method: 'GET',
	      url: '/examens'
	   }).then(function (success){
		   $scope.examens = success.data;
		   $scope.nombreexamens= $scope.examens.length ;
	   },function (error){
		   console.log(error)
	   });
	 
	 
	 var photoChange = 0;
	 
	 publicCtrl.urlPost = "/";
	 publicCtrl.choixUtilisateur = 'etudiant';
	 publicCtrl.loginUtilisateur = {};
     publicCtrl.nouveauUtilisateur = {photo :{urlPath:"http://localhost:8080/files/unkown.png"}};
     publicCtrl.sexes = SharedData.sexes;
	     SharedData.getClasses().then(function(succ){
			 publicCtrl.classes = succ.data;
		 });
	     publicCtrl.majChoix = function(){
	    	 publicCtrl.urlPost += (publicCtrl.choixUtilisateur+'s');
	     }
	     publicCtrl.creer = function(){
	    	 console.log("hcen");
	    	 $http({
		 			method: 'POST',
		 	      url: publicCtrl.urlPost,
		 	      dataType: 'json',
		 	      data    : publicCtrl.nouveauUtilisateur,
		 	      headers : {
		 		        'Content-Type' : 'application/json'
		 		    }
		 	      }).then(function (success){
		 	    	  console.log(success.data);
		 	   	   },function (error){
		 	   		   console.log(error);
		 	   	   });
	    	 
	     }
	     publicCtrl.majDefaultPhoto = function(){
	    	 if(photoChange == 0)
	    	 publicCtrl.nouveauUtilisateur.photo = SharedData.updateUnkownPhoto(publicCtrl.nouveauUtilisateur.sexe);
	 	}
	     publicCtrl.majPhoto = function(){
	    	 photoChange = 1;
	    	 var file = publicCtrl.photo;
	         SharedData.uploadImage(file).then(function (response) {
	        	 publicCtrl.nouveauUtilisateur.photo = JSON.parse(response.data);
	  		}, function (err) {
	  		});
	 	}
	/*     publicCtrl.connecter = function(){
	    	 console.log("iciiiiiiiiiiiiiiiiiiii");
	    	 $http({
		 			method: 'GET',
		 	      url: '/etudiants/par_nom/'+publicCtrl.loginUtilisateur.nom,
		 	      dataType: 'json',
		 	      headers : {
		 		        'Content-Type' : 'application/json'
		 		    }
		 	      }).then(function (response){
		 	    	
		 	    	  if(response.status == 200){
		 	    		 $cookies.putObject('loginUtilisateur',response.data);
		 	    		publicCtrl.espace = 'privee';
		 	    		 //
		 	    		
		 	    		$state.go("profil");
		 	    	  }
		 	    	  else{
		 	    		 console.log(response.data);
		 	    	  }
		 	    	
		 	    	  
		 	   	   });
	    	 
	     }*/
	     
	 
	  $scope.envoyermessage = function(){
	    	
	    	 $http({
		 			method: 'POST',
		 	      url: "/messagespubliques",
		 	      dataType: 'json',
		 	      data    : $scope.messag,
		 	      headers : {
		 		        'Content-Type' : 'application/json'
		 		    }
		 	      }).then(function (success){
		 	    	  console.log(success.data);
		 	   	   },function (error){
		 	   		   console.log(error);
		 	   	   });
	    	 
	     }
})

.controller('CoursController',function($http,$cookies,$window)
{
	var  coursCtrl = this;
	coursCtrl.listesCours=[];
	
	
	$http({
		method: 'GET',
      url: '/cours'
   }).then(function (success){
	   coursCtrl.cours = success.data;
	   angular.forEach(coursCtrl.cours,function(value,key){
		   $http({
				method: 'GET',
		      url: '/enseignants/'+coursCtrl.cours[key].idEnseignant
		   }).then(function(resp){
			   coursCtrl.cours[key].enseignant = resp.data;
		   });
	   });
		   
	   	   
	   });
	coursCtrl.m_a_jNbreLecture = function(cours){
		cours.nbreDeVus = cours.nbreDeVus + 1 ;
		   $http({
	 			method: 'PUT',
	 	      url: '/cours/'+cours.idCours,
	 	      dataType: 'json',
	 	      data    : cours,
	 	      headers : {
	 		        'Content-Type' : 'application/json'
	 		    }
	 	      });
	   }
	coursCtrl.voirProfil = function(e){
		$cookies.putObject('profilCookies',e);
		$state.transitionTo('profil');
	}
	
})
.controller('ContactsController',function($http,$cookies)
	{
	var contactsCtrl = this;
	
	contactsCtrl.anonyme = {photo:{urlPath : "http://localhost:8080/files/unkown.png"},username:"anonyme",etat : "anonyme",idClasse:"inconnu"};
	
	contactsCtrl.etudiants = {};
	contactsCtrl.test="aaa";
	contactsCtrl.enseignants = {};
	contactsCtrl.amiCookie = {};
	contactsCtrl.popupVisible = false;
	contactsCtrl.admin = {};
	
	/*$http({
		method: 'GET',
      url: '/admins'
   }).then(function(resp){
	   contactsCtrl.admin = (resp.data)[0];
   });*/
	
	contactsCtrl.afficher_popup = function(e){
		
		$cookies.putObject('amiCookie',e);
		$http({
			method: 'GET',
	      url: '/etudiants/'+e.idEtudiant
	   }).then(function(resp){
		   contactsCtrl.amiCookie = resp.data;
	   });
		
    contactsCtrl.popupVisible = true;
		
	}
	contactsCtrl.masquerPopup = function()
	{
		contactsCtrl.popupVisible = false;
	}
		
	contactsCtrl.amiCookie = $cookies.getObject('amiCookie');
	
	contactsCtrl.getEnseignants = function(){
			$http({
				method: 'GET',
		      url: '/enseignants'
		   }).then(function (success){
			   contactsCtrl.enseignants = success.data;
		   },function (error){
			   console.log(error);
		   });
		}
	contactsCtrl.getEtudiants = function(){
		$http({
			method: 'GET',
	      url: '/etudiants'
	   }).then(function (success){
		   contactsCtrl.etudiants = success.data;
	   },function (error){
		   console.log(error);
	   });
	}
	contactsCtrl.getEnseignants();
	contactsCtrl.getEtudiants();
	contactsCtrl.voirProfil = function(e){
		$cookies.putObject('profilCookies',e);
		if($state.current.name == 'profil')
			$state.reload();
		else
		$state.transitionTo('profil');
		
	}
	contactsCtrl.envoyerMessage = function(){
		contactsCtrl.message.dateDeCreation = new Date();
		$http({
 			method: 'POST',
 	      url: "/messagespubliques",
 	      dataType: 'json',
 	      data    : contactsCtrl.message,
 	      headers : {
 		        'Content-Type' : 'application/json'
 		    }
 	      }).then(function (success){
 	    	 contactsCtrl.message = {};
 	    	contactsCtrl.message.mail = "";
 	   	   },function (error){
 	   		   console.log(error);
 	   	   });
	 
 }	
		/*$http({
			method: 'POST',
	      url: '/etudiants',  
	      dataType: 'json',
	      data : contactsCtrl.anonyme,
 	      headers : {
 		        'Content-Type' : 'application/json'
 		    }
	   }).then(function (success){
		   contactsCtrl.message.dateDeCreation = new Date();
		   contactsCtrl.message.idUtilisateur = success.data.idEtudiant;
		   contactsCtrl.message.idDestinataire = "5ad8468e9842b40c248e00c6";
		   $http({
				method: 'POST',
		      url: '/messages',
		      data:contactsCtrl.message
		   }).then(function(rep){
			   contactsCtrl.anonyme.nom = "";
			   contactsCtrl.anonyme.addressMail = "";
			   contactsCtrl.message = {};
		   });
	   });
	}*/
})	
	
.controller('GestioncoursController',function($http)
	{
		var gestioncoursCtrl = this; 
		gestioncoursCtrl.nouveauCours = {};
		gestioncoursCtrl.nouveauCours.classesId = ['2info2'];
		gestioncoursCtrl.doUploadDocument = function(){
	        var file = gestioncoursCtrl.uploadedDocument;
	        var url = "/uploadfile";
	        
	        var data = new FormData();
	        data.append('uploadfile', file);
	     
	        var config = {
	     	   	transformRequest: angular.identity,
	     	   	transformResponse: angular.identity,
	 	   		headers : {
	 	   			'Content-Type': undefined
	 	   	    }
	        }
	        
	        $http.post(url, data, config).then(function (response) {
	        	gestioncoursCtrl.nouveauCours.document = JSON.parse(response.data);
	 		}, function (response) {
	 			gestioncoursCtrl.uploadResult=response.data;
	 			
	 		});
	     };
	     gestioncoursCtrl.ajouter = function(){
	 		$http({
	 			method: 'POST',
	 	      url: '/cours',
	 	      dataType: 'json',
	 	      data    : gestioncoursCtrl.nouveauCours,
	 	      headers : {
	 		        'Content-Type' : 'application/json'
	 		    }
	 	      }).then(function (success){
	 	    	  console.log(success.data);
	 	   	   },function (error){
	 	   		   console.log(error);
	 	   	   });
	 	}
	})
	
	
.controller("EtudiantsController",function($http,$cookies,$state,SharedData,$rootScope){
	$rootScope.etatGeneral="true";
	var etudiantsCtrl = this;
	etudiantsCtrl.sexes = SharedData.sexes;
	etudiantsCtrl.user = {photo : {urlPath : "http://localhost:8080/files/unkown.png"}};
	etudiantsCtrl.selectedEtudiant = {};
	etudiantsCtrl.classes = [];
	

	etudiantsCtrl.confirmer = function(id)
	{
		$http({
			method: 'GET',
	      url: '/etudiants/'+id+'/confirmation'
	   }).then(function (success){
		   $state.reload();
	   },function (error){
		   console.log(error);
	   });
	}
	etudiantsCtrl.refuser = function(id)
	{
		$http({
			method: 'DELETE',
	      url: '/etudiants/'+id
	   }).then(function (success){
		   $state.reload();
	   },function (error){
		   console.log(error);
	   });
	}
	etudiantsCtrl.updatePhoto = function(){
		etudiantsCtrl.user.photo = SharedData.updateUnkownPhoto(etudiantsCtrl.user.sexe);
	}
	etudiantsCtrl.ajouter = function(){
		$http({
			method: 'POST',
	      url: '/etudiants',
	      dataType: 'json',
	      data    : etudiantsCtrl.user,
	      headers : {
		        'Content-Type' : 'application/json'
		    }
	      }).then(function (success){
	    	  
	    	  $state.reload();
	    	 
	   	   },function (error){
	   		   console.log(error);
	   	   });
	}
	
	etudiantsCtrl.getSelectedEtudiant = function(id){
		$http({
			method: 'GET',
	      url: '/etudiants/'+id
	   }).then(function (success){
		   etudiantsCtrl.selectedEtudiant = success.data;
		   $cookies.putObject('profilCookies',etudiantsCtrl.selectedEtudiant);
		   $state.transitionTo('profil');
	   },function (error){
		   console.log(error);
	   });
	}
	etudiantsCtrl.doUploadImage = function(){
        var file = etudiantsCtrl.uploadedImage;
        SharedData.uploadImage(file).then(function (response) {
        	etudiantsCtrl.user.photo = JSON.parse(response.data);
 		}, function (err) {
 			console.log(err);
 		});
     };
     SharedData.getClasses().then(function (success){
    	 etudiantsCtrl.classes = success.data;
	   },function (error){
		   console.log(error);
	   });
     etudiantsCtrl.getEtudiants = SharedData.getEtudiants().then(function (success){
		   etudiantsCtrl.etudiants = success.data;
	   },function (error){
		   console.log(error);
	   });
	
})

.controller('EnseignantsController',function($http,$state,SharedData)
	{
	 var enseignantsCtrl = this;
	 enseignantsCtrl.enseignants = {};
	 enseignantsCtrl.classes = {};
	 enseignantsCtrl.sexes = SharedData.sexes;
	 enseignantsCtrl.user = {photo :{urlPath:"http://localhost:8080/files/unkown.png"},classesId : []};

	 enseignantsCtrl.count = 0;
	 enseignantsCtrl.update = function()
	 {
		 enseignantsCtrl.count++;
	 }
	 enseignantsCtrl.updatePhoto = function(){
			enseignantsCtrl.user.photo = SharedData.updateUnkownPhoto(enseignantsCtrl.user.sexe);
		}
	 SharedData.getClasses().then(function (success){
			   enseignantsCtrl.classes = success.data;
		   },function (error){
			   console.log(error);
		   });
		

	 SharedData.getEnseignants().then(function (success){
			   enseignantsCtrl.enseignants = success.data;
		   },function (error){
			   console.log(error);
		   });
	 
	 enseignantsCtrl.ajouter = function(){
			$http({
				method: 'POST',
		      url: '/enseignants',
		      dataType: 'json',
		      data    : enseignantsCtrl.user,
		      headers : {
			        'Content-Type' : 'application/json'
			    }
		      }).then(function (success){
		    	  
		    	  $state.reload();
		   	   },function (error){
		   		   console.log(error);
		   	   });
		}
	 enseignantsCtrl.doUploadImage = function(){
	        var file = enseignantsCtrl.uploadedImage;
	        SharedData.uploadImage(file).then(function (response) {
	        	enseignantsCtrl.user.photo = JSON.parse(response.data);
	 		}, function (err) {
	 			console.log(err);
	 		});
	     };
	     SharedData.getClasses().then(function (success){
	    	 enseignantsCtrl.classes = success.data;
		   },function (error){
			   console.log(error);
		   });
	 
	 
	})
.controller('ProfilController',function($http,$cookies,$state,SharedData)
	{
	 var profilCtrl = this;
	 profilCtrl.profilClasse = {};
	 profilCtrl.profilCookie = $cookies.getObject('profilCookies');
	 profilCtrl.getClasse = function(id){
			$http({
				method: 'GET',
		      url: '/classes/'+id
		   }).then(function (success){
			   profilCtrl.profilClasse =  success.data;
		   },function (error){
			   console.log(error);
		   });
		}
	 profilCtrl.profilClasse = profilCtrl.getClasse(profilCtrl.profilCookie.idClasse);
	 profilCtrl.afficherCours = function(cours){
		 $cookies.putObject('cours',cours)
		 $state.transitionTo('cours');
	 }
	 
	})
.controller('FichiersController',function($http,$sce,SharedData){
	var fichiersCtrl = this;
	fichiersCtrl.doGetFiles = function(){
       var url = "/getallfilesname";
       $http.get(url).then(function (response) {
    	   fichiersCtrl.lstFiles = response.data;
		}, function (response) {
			alert(response.data);
		});
    };
    fichiersCtrl.doUploadFile = function(){
        var file = fichiersCtrl.uploadedFile;
        var url = "/uploadfile";
        
        var data = new FormData();
        data.append('uploadfile', file);
     
        var config = {
     	   	transformRequest: angular.identity,
     	   	transformResponse: angular.identity,
 	   		headers : {
 	   			'Content-Type': undefined
 	   	    }
        }
        
        $http.post(url, data, config).then(function (response) {

        	console.log(file);
        	fichiersCtrl.uploadResult=response.data;
 		}, function (response) {
 			fichiersCtrl.uploadResult=response.data;
 			
 		});
     };
})
.controller('TempsController',function($interval,$window)
	{
	
	var tempsCtrl = this;
	$interval(majTemps,1000);
	tempsCtrl.startTimeValue = 1430990693334;

	tempsCtrl.date = new Date();
	function majTemps(){
		tempsCtrl.date = new Date();
		
	}
	var date1 = new Date("2018-02-22T01:27:20Z");
	tempsCtrl.date2 = date1.getMinutes() + 28;
	if(((tempsCtrl.date.getHours()+12 )>= date1.getHours() ) && (tempsCtrl.date.getMinutes >= (date1.getMinutes() + 28)))
		$window.alert("You have a Quiz to pass now !!");			
	})	


.controller("ClassesController",function($http,$state,$rootScope,$scope){
	$scope.a=true;
	$scope.name=$rootScope.name;
	var classesCtrl = this;
	classesCtrl.activeClasse = null;
	classesCtrl.listeEtudiants = null;
	classesCtrl.getClasses = function(){
		$http({
			method: 'GET',
	      url: '/classes'
	   }).then(function (success){
		   classesCtrl.classes = success.data;
	   },function (error){
		   console.log(error);
	   });
	}
	classesCtrl.getClasse = function(id){
		$http({
			method: 'GET',
	      url: '/classes/'+id
	   }).then(function (success){
		   classesCtrl.activeClasse =  success.data;
	   },function (error){
		   console.log(error);
	   });
	}
	classesCtrl.getActiveClasse = function(id){
		classesCtrl.activeClasse = classesCtrl.getClasse(id);
	}
	classesCtrl.getEtudiantsParClasseId = function(id){
		$http({
			method: 'GET',
	      url: '/etudiants/parclasseid/'+id
	   }).then(function (success){
		   classesCtrl.listeEtudiants =  success.data;
	   },function (error){
		   console.log(error);
	   });
		
	}
	
	classesCtrl.ajouter = function(){
		$http({
			method: 'POST',
	      url: '/classes',
	      dataType: 'json',
	      data    : classesCtrl.classe,
	      headers : {
		        'Content-Type' : 'application/json'
		    }
	      }).then(function (success){
	    	  $state.reload();
	   	   },function (error){
	   		   console.log(error);
	   	   });
	}
	classesCtrl.getClasses();
	   
})	   
	   ;
