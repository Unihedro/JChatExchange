# How to Contribute

**JChatExchange** is a project built by a community and is community driven. We're very happy when anyone else want to jump in and get involved, so here's what you need to know.

## Quick Guide
- If you want, create an issue about the proposed change on [the issue tracker][issues].
- You'll need a GitHub account. [Sign up for one if you don't have one.][signup]
- Fork the repository if you haven't done so already.
- Make your changes in a new branch.
  * If your changes affects an existing implementation, please update the documentation.
  * If your changes implements an existing interface, please create the documentation, or make a note for others to document it.
  * Never change existing interfaces as hacks (they're terrible), instead expand with the best code which does what you want and deprecate the old methods.<br><sup>Add `@Deprecated` to old methods and document this change.</sup>
- Does your change preserve [the goals of the library](#goals), and fit [most of these criterias](#checklist)?
- Make your changes in your fork, and test your changes.
- _Confirm that it [(at least loosely) follows out formatting guidelines][formatting] for contributing. **- TBD**_
- Push to your fork and submit a pull request.

## <a name="goals"></a>Goals
The project is inspired and lightly based on [ChatExchange by Manishearth][Manishearth/ChatExchange] _(Python; build passing)_ and [ChatExchange.Net by ArcticEcho (Sam)][ArcticEcho/ChatExchange.Net] _(C#; in progress)_. The library JChatExchange is not an implementation of either of the mentioned libraries, but is a Java library for programmatically communicating with the Stack Exchange chat domains. You will be able to:
- Create a connection to the server through a method invocation;
- Send messages to the server and have automatic event querying from the server, handled by JChatExchange;
- Work with the above features across multiple rooms across the different Stack Exchange chat domains:
  * [http://chat.stackexchange.com/](http://chat.stackexchange.com/ "Stack Exchange Network Chat")
  * [http://chat.meta.stackexchange.com/](http://chat.meta.stackexchange.com/ "Meta Stack Exchange Chat")
  * [http://chat.stackoverflow.com/](http://chat.stackoverflow.com/ "Stack Overflow Chat")
  
JChatExchange is built in Java 8. <!-- Java 6 support is planned. --> <!-- maybe. -->

## <a name="checklist"></a>Quick Guide, 2
When contributing, __please ask yourself__:
1. Does the change expose or rely on an implementation detail or flaw which will change over time?

    If your change enables developers having to work around an implementation detail then it is not a proper API design. Examples of bad API design would be something revolving a packet storage API, or basing enums on return states of server responses.
    
2. Does it lead to unexpected behaviour as defined by dependencies or the Java Language Specification?

    One of the goals of the project is to enable developers using the library to talk to Stack Exchange chat without worrying about any protocol in the back end, it should function exactly as documented. If your change alters the behaviour away from what it was documented, then it is not a good change.

3. Does it expose vulnerabilities or issues when operating in the expected environment (over standard connection to Stack Exchange chat servers)?

    It should be remembered that the Stack Exchange chat environment also consists of users. All changes in implementations and features should remain consistent and the library should be able to handle and minimize the risk of damage caused by any garbage data and user influence in runtime.

If you answered `yes` to any of these questions, chances are your changes are harmful and may be debatable on whether it will be accepted. However, there are still a few things to bear in mind of when you start working on a change:

* Can you develop your change such that it is **reasonably maintainable**?

* Is this change **future proof**?

* Is it **supportable** with basic usages?

[issues]: https://github.com/Vincentyification/JChatExchange/issues
[signup]: https://github.com/signup/free
[Manishearth/ChatExchange]: https://github.com/Manishearth/ChatExchange
[ArcticEcho/ChatExchange.Net]: https://github.com/ArcticEcho/ChatExchange.Net