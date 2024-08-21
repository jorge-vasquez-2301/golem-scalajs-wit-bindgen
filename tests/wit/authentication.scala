
                // Generated by golem-scalajs-wit-bindgen
                package tests

                import scala.scalajs.js
                import scala.scalajs.js.JSConverters._

                
                sealed trait AuthResult extends js.Object {
                    val userId: Integer
val token: String
                }
                object AuthResult {
                    def apply(userId: Integer, token: String): AuthResult = {
                        val userId0: Integer = userId
val token0: String = token

                        new AuthResult {
                            val userId: Integer = userId0
val token: String = token0
                        }
                    }
                }
            

                sealed trait UserCredentials extends js.Object {
                    val username: String
val passwordHash: String
val salt: String
                }
                object UserCredentials {
                    def apply(username: String, passwordHash: String, salt: String): UserCredentials = {
                        val username0: String = username
val passwordHash0: String = passwordHash
val salt0: String = salt

                        new UserCredentials {
                            val username: String = username0
val passwordHash: String = passwordHash0
val salt: String = salt0
                        }
                    }
                }
            

                
                sealed trait LoginResult extends js.Object { self =>
                    type Type

                    val tag: String
                    val `val`: js.UndefOr[Type]
                }

                object LoginResult {
                    
                            def success(value: AuthResult) = new LoginResult {
                                type Type = AuthResult
                                
                                val tag: String = "success"
                                override val `val`: js.UndefOr[Type] = value
                            }
                        

                            def failure(value: LoginError) = new LoginResult {
                                type Type = LoginError
                                
                                val tag: String = "failure"
                                override val `val`: js.UndefOr[Type] = value
                            }
                        
                }
            

                sealed trait AuthStatus extends js.Object { self =>
                    type Type

                    val tag: String
                    val `val`: js.UndefOr[Type]
                }

                object AuthStatus {
                    
                            def valid(value: Integer) = new AuthStatus {
                                type Type = Integer
                                
                                val tag: String = "valid"
                                override val `val`: js.UndefOr[Type] = value
                            }
                        

                            val expired = new AuthStatus {
                                type Type = Nothing
                                
                                val tag: String = "expired"
                                
                            }
                        

                            val invalid = new AuthStatus {
                                type Type = Nothing
                                
                                val tag: String = "invalid"
                                
                            }
                        
                }
            

                trait Api {
                    type WitResult[+Ok, +Err] = Ok
                    object WitResult {
                        def ok[Ok](value: Ok): WitResult[Ok, Nothing] = value

                        def err[Err](value: Err): WitResult[Nothing, Err] = throw js.JavaScriptException(value)

                        val unit: WitResult[Unit, Nothing] = ()
                    }

                    type WitOption[+A] = js.UndefOr[A]
                    object WitOption {
                        def some[A](value: A): WitOption[A] = value

                        val none: WitOption[Nothing] = js.undefined

                        def fromOption[A](option: Option[A]) =
                        option match {
                            case Some(value) => value.asInstanceOf[js.UndefOr[A]]
                            case None        => js.undefined
                        }
                    }

                    type WitList[A] = js.Array[A]
                    object WitList {
                        def fromList[A](list: List[A]): WitList[A] = list.toJSArray
                    }
                    
                    def registerUser(username: String, password: String, email: String): AuthResult
def login(username: String, password: String): LoginResult
def validateToken(token: String): AuthStatus
                }
            