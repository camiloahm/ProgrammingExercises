namespace FactsWebhooks

open System
open System.Collections.Generic
open System.Threading.Tasks
open Microsoft.WindowsAzure.Storage // Namespace for CloudStorageAccount
open Microsoft.WindowsAzure.Storage.Table // Namespace for Table storage type

type Fact(date, id, value: string) =
    inherit TableEntity(partitionKey=date, rowKey=id)
    new() = Fact(null, null,null)
    member val Value = value with get, set

