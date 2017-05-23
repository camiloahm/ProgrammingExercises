using System;
using System.Threading.Tasks;
using Microsoft.Azure.KeyVault;
using Microsoft.Extensions.Configuration;
using Microsoft.IdentityModel.Clients.ActiveDirectory;

public class EnvironmentSecretProvider
{



    //this is an optional property to hold the secret after it is retrieved
    public static string EncryptSecret { get; set; }

    //the method that will be provided to the KeyVaultClient
    public static async Task<string> GetToken(string authority, string resource, string scope)
    {
        var authContext = new AuthenticationContext(authority);
        ClientCredential clientCred = new ClientCredential("",
                    "");
        AuthenticationResult result = await authContext.AcquireTokenAsync(resource, clientCred);

        if (result == null)
            throw new InvalidOperationException("Failed to obtain the JWT token");

        return result.AccessToken;
    }

    public static async Task<string> GetSecret(string secret)
    {

        var kv = new KeyVaultClient(new KeyVaultClient.AuthenticationCallback(GetToken));

        var sec = await kv.GetSecretAsync(secret);

        //I put a variable in a Utils class to hold the secret for general  application use.
        return sec.Value;
    }

}