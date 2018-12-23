
> # Spring : utiliser une base de données

### CREATE![creation de donnée](https://i.postimg.cc/g08pcdZ5/CREATE.png)
```java
//  #################  CREATE ###################
// 	http://localhost:8080/create?firstName=momo&lastName=detoto&age=12
	@RequestMapping("/create")
	public Users createUser(String firstName, String lastName, int age) {
		Users user = new Users(firstName, lastName, age);
		return usersRepo.save(user);
	}
```
### READ BY ID 
![lecture d'une donnée](https://i.postimg.cc/13KTvtDy/READ.png)

```java
//  #################  READ BY ID ###################
//	http://localhost:8080/read?userId=1
	@RequestMapping("/read")
	public Users getUser(Long userId) {
		return usersRepo.findById(userId).get();
	}
```
### READ ALL
![lecture de tpute les données](https://i.postimg.cc/8C9b4QX1/READALL.png)

```java
//  #################  READ ALL ###################
//	http://localhost:8080/readall
	@RequestMapping("/readall")
	public List<Users> getAllUser() {
		return usersRepo.findAll();
	}
```
### UPDATE
![Mise à jour d'une donnée](https://i.postimg.cc/Gt7tPrzK/UPDATE.png)

```java
//  #################  UPDATE ###################
//	http://localhost:8080/update?userId=1&firstName=jeannoline&lastName=delarue&age=20
	@RequestMapping("/update")
	public Users updateUser(Long userId, String firstName, String lastName, int age) {
		Users userToUpdate = usersRepo.findById(userId).get();
		
		if(firstName != null) {
			userToUpdate.setfirstName(firstName);
		}
		if(lastName != null) {
			userToUpdate.setLastName(lastName);
		}
		if(age > 0) {
			userToUpdate.setAge(age);
		}
		return usersRepo.save(userToUpdate);
	}
```
### DELETE
![suppression de donnée](https://i.postimg.cc/zG5DLyJN/DELETE.png)

```java
//  #################  DELETE ###################
//	http://localhost:8080/delete?userId=1
	@RequestMapping("/delete")
	public void deleteUser(Long userId) {
		usersRepo.deleteById(userId);
	}
```
