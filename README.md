# ECS-Paper (WIP)
[![Build](https://github.com/nitkanikita21/ECS-Paper/actions/workflows/gradle.yml/badge.svg)](https://github.com/nitkanikita21/ECS-Paper/actions/workflows/gradle.yml)

ECS (Entity Component System) framework for creating custom behavior (as in gamedev) for Bukkit objects (ItemStack and others).

*This api is not implemented perfectly due to my knowledge. You can write all your suggestions to me at:*

*Discord: @nitkanikita21*
## Goal
This project is created solving the problem of implementing custom items, entities, etc. The implementation of these things is located in one place and is not scattered throughout the project.
## Modules
* [test-plugin](test-plugin/src/main/java/com/example) - example of use
* [root](src/main/java/com/nitkanikita21/ecspaper) - Paper plugin
* [Paper](Paper/src/main/java/com/nitkanikita21/ecspaper) - entrypoint on the ECS API
* [PaperCommons](PaperCommons/src/main/java/com/nitkanikita21/ecspaper) - commons for Paper platform
* [Core](Core/src/main/java/com/nitkanikita21/ecspaper/core) - ECS model api
* [Items](Items/src/main/java/com/nitkanikita21/ecspaper/items) - ECS implementation for ItemStack
## License
[MIT License](LICENSE)

by [nitkanikita21](https://github.com/nitkanikita21)